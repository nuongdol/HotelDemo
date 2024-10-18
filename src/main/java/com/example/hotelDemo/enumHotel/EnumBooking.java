package com.example.hotelDemo.enumHotel;

public enum EnumBooking {

    SUCCESSFUL("successful"),
    FAILED("failed");
    private final String status;

    EnumBooking(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }
}
