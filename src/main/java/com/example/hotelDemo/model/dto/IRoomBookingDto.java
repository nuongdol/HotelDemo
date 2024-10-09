package com.example.hotelDemo.model.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public interface IRoomBookingDto {

    Long getRoomId();

    LocalDate getCheckinDate();

    LocalDate getCheckoutDate();

    BigDecimal getTotalPrice();

    String getBookingStatus();

    String getRoomName();

    String getRoomType();

    String getRoomCapacity();

    BigDecimal getRoomPrice();

    String getRoomStatus();
}
