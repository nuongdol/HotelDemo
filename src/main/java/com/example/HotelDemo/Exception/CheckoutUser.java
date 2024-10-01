package com.example.HotelDemo.Exception;

public class CheckoutUser extends RuntimeException{
    public CheckoutUser(String message){
        super(message);
    }
}
