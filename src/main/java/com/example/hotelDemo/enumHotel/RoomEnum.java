package com.example.hotelDemo.enumHotel;


public enum RoomEnum {
    EMPTY("empty"),
    FULL("full");
    private final String status;

    RoomEnum(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }




}
