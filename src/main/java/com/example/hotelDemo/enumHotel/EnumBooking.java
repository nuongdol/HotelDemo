package com.example.hotelDemo.enumHotel;

public enum EnumBooking {
    SUCCESSFUL{
        public String toString() {
            return "successful";
        }
    },
    FAILED{
        public String toString() {
            return "failed";
        }
    };


}
