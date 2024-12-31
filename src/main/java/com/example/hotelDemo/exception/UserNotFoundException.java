package com.example.hotelDemo.exception;

public final class UserNotFoundException extends RuntimeException{
    private static final Long serialVersion = 5861310537366287163L;
    public UserNotFoundException(){
        super();
    }
    public UserNotFoundException(final String message, final Throwable cause){
        super(message, cause);
    }

    public UserNotFoundException(final String message){
        super(message);
    }
    public UserNotFoundException(final Throwable cause){
        super(cause);
    }

}
