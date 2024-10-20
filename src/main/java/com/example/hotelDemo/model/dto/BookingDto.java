package com.example.hotelDemo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    @Getter
    private List<RoomDto> rooms;

    public int NumberOfGuest(Integer numberOfChildren, Integer numberOfAdults) {
        this.totalNumberOfGuest = numberOfChildren + numberOfAdults;
            return totalNumberOfGuest;
    }

}
