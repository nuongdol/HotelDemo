package com.example.hotelDemo.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MappingRoomBookingDto {
    private Long id;
    @NotNull
    private Long roomId;
    @NotNull
    private Long bookingId;
}
