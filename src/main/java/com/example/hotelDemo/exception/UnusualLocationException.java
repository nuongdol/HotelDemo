package com.example.hotelDemo.exception;


import org.springframework.security.core.AuthenticationException;

public final class UnusualLocationException extends AuthenticationException {

    private static final Long serialVersion = 5861310537366287163L;
    ;

    public UnusualLocationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnusualLocationException(final String message) {
        super(message);
    }

}
