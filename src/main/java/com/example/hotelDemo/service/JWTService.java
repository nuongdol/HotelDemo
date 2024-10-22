package com.example.hotelDemo.service;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;


public interface JWTService {
    String generateToken(String userName);
    String extractUserNameFromToken(String theToken);
    Date extractExpirationTimeFromToken(String theToken);
    boolean isTokenExpired(String theToken);
    boolean validateToken(String theToken, UserDetails userDetails);
}
