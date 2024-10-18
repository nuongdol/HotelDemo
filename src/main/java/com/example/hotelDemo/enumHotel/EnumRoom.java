package com.example.hotelDemo.enumHotel;


public enum EnumRoom {
    EMPTY("empty"),
    FULL("full");
    private final String status;

    EnumRoom(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }




}
