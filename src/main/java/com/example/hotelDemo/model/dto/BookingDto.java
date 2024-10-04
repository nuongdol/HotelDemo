package com.example.hotelDemo.model.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingDto {

    private Long bookingId;

    private Long userId;

    private Long hotelId;

    private LocalDate checkinDate;

    private LocalDate checkoutDate;

    private BigDecimal totalPrice;

    private Integer numberOfAdults;

    private Integer numberOfChildren;

    private Integer totalNumberOfGuest;

    private String paymentMethod;

    private String bookingStatus;

}
