package com.example.hotelDemo.model.dto;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RoomDto {

    private Long roomId;

    private Long hotelId;

    private String roomName;

    private String roomType;

    private String roomCapacity;

    private BigDecimal roomPrice;

    private String roomDescription;

    private String roomStatus;

    private String roomImage;


}
