package com.example.HotelDemo.Model.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DetailedBookingDto {

    private Long bookingId;

    private Long userId;

    private Long roomId;

    private LocalDate checkinDate;

    private LocalDate checkoutDate;

    private BigDecimal totalPrice;

    private String bookingStatus;

    private Integer numberOfAdults;

    private Integer numberOfChildren;

    private Integer totalNumberOfGuest;

    private String bookingConfirmation;

    private String paymentMethod;
}
