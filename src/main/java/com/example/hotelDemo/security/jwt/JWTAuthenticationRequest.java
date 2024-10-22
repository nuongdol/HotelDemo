package com.example.hotelDemo.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTAuthenticationRequest {
    private String userName;
    private String password;
}
