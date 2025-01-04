package com.example.hotelDemo.enumHotel;

public enum BookingEnum {

    SUCCESSFUL("successful"),
    FAILED("failed");
    private final String status;

    BookingEnum(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }
}
