package com.example.HotelDemo.Model.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RoomBookingDto {

    private Long bookingId;

    private Long roomId;

    private LocalDate checkinDate;

    private LocalDate checkoutDate;

    private BigDecimal totalPrice;

    private String bookingStatus;

    private String roomName;

    private String roomType;

    private String roomCapacity;

    private BigDecimal roomPrice;


}
