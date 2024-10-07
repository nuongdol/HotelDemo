package com.example.hotelDemo.model.dto;

<<<<<<< HEAD

=======
>>>>>>> 17fb990 (eight commit)
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
