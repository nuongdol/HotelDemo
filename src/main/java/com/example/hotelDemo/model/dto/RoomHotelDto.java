package com.example.hotelDemo.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomHotelDto {

    private String hotelName;

    private String hotelAddress;

    private String hotelCity;

    private String hotelImage;

    private Long roomId;

    private Long hotelId;

    private String roomName;

    private String roomType;

    private String roomCapacity;

    private BigDecimal roomPrice;

    private String roomDescription;

    private String roomStatus;

    private String roomImage;

}
