package com.example.hotelDemo.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RoomUserBookingDto {
    private Long bookingId;

    private Long userId;

    private Long roomId;

    private LocalDate checkinDate;

    private LocalDate checkoutDate;

    private BigDecimal totalPrice;

    private String bookingStatus;

    private Long hotelId;

    private String roomName;

    private String roomType;

    private String roomCapacity;

    private BigDecimal roomPrice;

    private String roomDescription;

    private String roomStatus;

    private String roomImage;

    private String userName;

    private String email;

    private String phone;

    private String address;

    private String password;
}
