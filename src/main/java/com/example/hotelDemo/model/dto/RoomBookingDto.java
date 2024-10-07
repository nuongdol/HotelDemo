package com.example.hotelDemo.model.dto;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomBookingDto {

    Long BookingId;

    Long RoomId;

    LocalDate CheckinDate;

    LocalDate CheckoutDate;

    BigDecimal TotalPrice;

    String BookingStatus;

    String RoomName;

    String RoomType;

    String RoomCapacity;

    BigDecimal RoomPrice;

    String RoomStatus;

}
