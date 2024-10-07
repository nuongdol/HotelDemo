package com.example.hotelDemo.model.dto;

import lombok.Data;

import java.math.BigDecimal;


public interface RoomHotelDto {

     String getHotelName();

     String getHotelAddress();

     String getHotelCity();

     String getHotelImage();

     Long getRoomId();

     Long getHotelId();

     String getRoomName();

     String getRoomType();

     String getRoomCapacity();

    BigDecimal getRoomPrice();

    String getRoomDescription();

    String getRoomStatus();

    String getRoomImage();

}
