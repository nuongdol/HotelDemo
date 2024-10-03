package com.example.HotelDemo.Model.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class HotelDto {
    private Long hotelId;

    private String hotelName;

    private String hotelAddress;

    private String hotelCity;

    private String hotelImage;
}
