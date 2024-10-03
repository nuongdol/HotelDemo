package com.example.HotelDemo.Model.Dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingDto {

    private Long bookingId;

    private Long userId;

    private Long roomId;

    private LocalDate checkinDate;

    private LocalDate checkoutDate;

    private BigDecimal totalPrice;

    private String bookingStatus;


}
