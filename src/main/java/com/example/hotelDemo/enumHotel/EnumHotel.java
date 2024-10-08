package com.example.hotelDemo.enumHotel;

public enum EnumHotel {

    ACTIVITY("Activity"),
    NON_ACTIVITY("Non Activity");
    private final String status;

    EnumHotel(String status){
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }
}
