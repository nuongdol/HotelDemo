package com.example.HotelDemo.Exception;

public class CheckoutBooking extends RuntimeException {
    public CheckoutBooking(String message) {
        super(message);
    }
}
