package com.example.hotelDemo.enumHotel;

public enum EnumHotel {

    ACTIVITY("existent"),
    NON_ACTIVITY("non-existent");
    private final String status;

    EnumHotel(String status){
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }
}
