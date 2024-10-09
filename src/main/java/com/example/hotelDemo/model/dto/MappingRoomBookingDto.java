package com.example.hotelDemo.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MappingRoomBookingDto {

    private Long id;

    private Long roomId;

    private Long bookingId;
}
