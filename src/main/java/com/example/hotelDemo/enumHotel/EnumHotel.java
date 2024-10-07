package com.example.hotelDemo.enumHotel;

public enum EnumHotel {
    ACTIVITY {
        @Override
        public String toString() {
           return "Activity";
        }
    },
    NON_ACTIVITY {
        @Override
        public String toString() {
            return "Non Activity";
        }
    };

}
