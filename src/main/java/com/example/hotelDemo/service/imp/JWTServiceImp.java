package com.example.hotelDemo.service.imp;

import com.example.hotelDemo.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceImp implements JWTService {
    @Value("${spring.jwt.secret}")
    private String JWT_SECRET;

    @Value("${spring.jwt.jwtExpirationInMs}")
    private int JWT_EXPIRATION_TIME_IN_MILLISECONDS;

   @Override
    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return tokenCreator(claims, userName);
    }

    private String tokenCreator(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME_IN_MILLISECONDS))
                .signWith(getSignedKey(), SignatureAlgorithm.ES256).compact();
    }

    public String extractUserNameFromToken(String theToken){
        return extractClaim(theToken, Claims::getSubject);
    }


    public Date extractExpirationTimeFromToken(String theToken){
        return extractClaim(theToken, Claims::getExpiration);

    }
    private <T> T extractClaim(String theToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(theToken);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String theToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignedKey())
                .build()
                .parseClaimsJwt(theToken)
                .getBody();
    }

    private Key getSignedKey() {
        byte[] keyByte = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public boolean isTokenExpired(String theToken){
        return extractExpirationTimeFromToken(theToken).before(new Date());
    }

    @Override
    public boolean validateToken(String theToken, UserDetails userDetails) {
       final String userName = extractUserNameFromToken(theToken);
       return (userName.equals(userDetails.getUsername()) && !isTokenExpired(theToken));
    }

}
