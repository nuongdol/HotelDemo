package com.example.hotelDemo.model.dto;

import java.time.LocalDate;

public interface IRoomBookingDTO {

    LocalDate getCheckinDate();

    Long getBookId();

    LocalDate getCheckoutDate();
}
