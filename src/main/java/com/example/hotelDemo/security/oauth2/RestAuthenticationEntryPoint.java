package com.example.hotelDemo.security.oauth2;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
lop nay duoc goi khi nguoi dung co gang truy cap vao mot tai nguyen duoc bao ve
ma khong can xac thuc. Trong truong hop nay chung ta tra ve phan hoi 401
* */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
        throws IOException, ServletException {
        logger.error("Responding with unauthorized error. Message -{}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
            authException.getLocalizedMessage());
    }
}
