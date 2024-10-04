package com.example.hotelDemo.model.dto;

import lombok.Data;

@Data
public class HotelDto {
    private Long hotelId;

    private String hotelName;

    private String hotelAddress;

    private String hotelCity;

    private String hotelImage;
}
