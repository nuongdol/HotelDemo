package com.example.hotelDemo.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.hotelDemo.enumHotel.AuthProviderEnum;
import com.example.hotelDemo.exception.BadRequestException;
import com.example.hotelDemo.model.User;
import com.example.hotelDemo.payload.response.ApiResponse;
import com.example.hotelDemo.payload.response.AuthResponse;
import com.example.hotelDemo.payload.response.LoginRequest;
import com.example.hotelDemo.payload.response.SignUpRequest;
import com.example.hotelDemo.repository.UserRepository;
import com.example.hotelDemo.security.oauth2.TokenProvider;
import jakarta.validation.Valid;

/*
bo dieu khien va dich vu de xu ly email va dang nhap
dua tren mat khau
* */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }
        //creating user 's account
        User user = new User();
        user.setUserName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setAuthProvider(AuthProviderEnum.LOCAL);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
            .fromCurrentContextPath().path("/user/me")
            .buildAndExpand(result.getUserId()).toUri();

        return ResponseEntity.created(location)
            .body(new ApiResponse(true, "User registered successfully"));
    }

}
