package com.example.hotelDemo.exception;

public class InvalidHotelRequestException extends RuntimeException {
    public InvalidHotelRequestException(String message) {
        super(message);
    }
}
