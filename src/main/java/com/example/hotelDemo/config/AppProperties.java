package com.example.hotelDemo.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private final Auth auth = new Auth();
    private final OAuth2 oauth2 = new OAuth2();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Auth{
        private String tokenSecret;
        private long tokenExpirationMsec;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static final class OAuth2{
        private List<String> authorizedRedirectUri = new ArrayList<>();
    }
}
