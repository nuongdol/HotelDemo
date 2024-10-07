package com.example.hotelDemo.model.dto;


<<<<<<< HEAD
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
=======
>>>>>>> 17fb990 (eight commit)
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

<<<<<<< HEAD
    LocalDate CheckinDate;

    LocalDate CheckoutDate;

    BigDecimal TotalPrice;

    String BookingStatus;

    String RoomName;

    String RoomType;

    String RoomCapacity;

    BigDecimal RoomPrice;

=======
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

>>>>>>> 17fb990 (eight commit)
    String RoomStatus;

}
