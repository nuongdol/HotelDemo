package com.example.hotelDemo.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IUserBookingRoomDto {

     Long getUserId();

     String getUserName();


     String getPassword();

     String getEmail();

     String getPhone();

     String getAddress();

     Long getRoomId();

     Long getHotelId();

     String getRoomName();

     String getRoomType();

     String getRoomCapacity();

     BigDecimal getRoomPrice();

     String getRoomDescription();

     String getRoomStatus();

     String getRoomImage();

     Long getBookingId();

     LocalDate getCheckinDate();

     LocalDate getCheckoutDate() ;

     BigDecimal getTotalPrice();

     Integer getNumberOfAdults();

     Integer getNumberOfChildren();

     Integer getTotalNumberOfGuest();

     String getPaymentMethod();

     String getBookingStatus();
}
