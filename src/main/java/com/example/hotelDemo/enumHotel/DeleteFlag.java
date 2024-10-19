package com.example.hotelDemo.enumHotel;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum DeleteFlag {

    DELETE(0), NOT_YET_DELETED(1);

    private final int value;

    /* constructor
    DeleteFlag(int value) {
        this.value = value;
    }
    */

}
