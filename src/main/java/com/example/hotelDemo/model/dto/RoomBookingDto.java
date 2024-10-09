package com.example.hotelDemo.model.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomBookingDto {
    @NotNull
    Long BookingId;
    @NotNull
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
