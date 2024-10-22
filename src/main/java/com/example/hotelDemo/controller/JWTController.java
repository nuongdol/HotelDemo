package com.example.hotelDemo.controller;

import com.example.hotelDemo.security.jwt.JWTAuthenticationRequest;
import com.example.hotelDemo.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authenticate")
public class JWTController {


    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping
    public String getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authenticationRequest){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authenticationRequest.getUserName());
        }else {
            throw new UsernameNotFoundException("Invalid user credentials");//thong tin nguoi dang nhap ko phu hop
        }
    }


}
