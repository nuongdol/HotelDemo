package com.example.HotelDemo.Exception;

public class CheckoutRoom extends RuntimeException {
    public CheckoutRoom(String message) {
        super(message);
    }
}
