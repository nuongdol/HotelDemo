package com.example.hotelDemo.exception;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserAlreadyExistException extends RuntimeException {

    private static final Long seriaVersionUID = 5861310537366287163L;

    public UserAlreadyExistException(){
        super();
    }
    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }
    public UserAlreadyExistException(final String message){
        super(message);
    }
    public UserAlreadyExistException(final Throwable cause){
        super(cause);
    }
}
