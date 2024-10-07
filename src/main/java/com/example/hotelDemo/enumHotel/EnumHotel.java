package com.example.hotelDemo.enumHotel;

public enum EnumHotel {
<<<<<<< HEAD

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
=======
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

>>>>>>> 17fb990 (eight commit)
}
