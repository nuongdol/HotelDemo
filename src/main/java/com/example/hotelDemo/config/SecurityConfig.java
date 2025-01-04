package com.example.hotelDemo.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.hotelDemo.security.oauth2.CustomOAuth2UserService;
import com.example.hotelDemo.security.oauth2.CustomUserDetailsService;
import com.example.hotelDemo.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.example.hotelDemo.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.example.hotelDemo.security.oauth2.OAuth2AuthenticationSuccessHandler;
import com.example.hotelDemo.security.oauth2.RestAuthenticationEntryPoint;
import com.example.hotelDemo.security.oauth2.TokenAuthenticationFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @Autowired
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Value("$security.oauth2.client.registration.google.clientId")
    private String clientId;

    @Value("$security.oauth2.client.registration.google.clientSecret")
    private String clientSecret;

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }
    /* Luu thong tin cau hinh OAuth2 Client
    * */
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(googleClientRegistration());
    }

    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("google")
            .clientId(clientId)
            .clientSecret(clientSecret)
            .scope("profile", "email")
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE) // Quan trọng
            .authorizationUri("https://accounts.google.com/o/oauth2/auth")
            .tokenUri("https://oauth2.googleapis.com/token")
            .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
            .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
            .build();
    }

    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
//        this.customUserDetailsService = customUserDetailsService;
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(Customizer.withDefaults())
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .authenticationEntryPoint(new RestAuthenticationEntryPoint()))
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/auth/**", "/oauth2/**")
                .permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**")
                .permitAll()
                .anyRequest().authenticated())
            .oauth2Login(oauth2Login -> oauth2Login
                .authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint
                    .baseUri("/oauth2/authorize")
                    .authorizationRequestRepository(cookieAuthorizationRequestRepository()))
                .redirectionEndpoint(redirectionEndpoint -> redirectionEndpoint
                    .baseUri("/oauth2/callback/*"))
                .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                    .userService(customOAuth2UserService))
                .successHandler(oAuth2AuthenticationSuccessHandler)
                .failureHandler(oAuth2AuthenticationFailureHandler));

        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}



