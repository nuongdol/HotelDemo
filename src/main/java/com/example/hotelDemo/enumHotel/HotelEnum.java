package com.example.hotelDemo.enumHotel;

public enum HotelEnum {

    ACTIVITY("existent"),
    NON_ACTIVITY("non-existent");
    private final String status;

    HotelEnum(String status){
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }
}
