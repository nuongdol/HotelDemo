package com.example.HotelDemo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "hotel_id")
    private Long hotelId;

    private String roomName;

    private String roomType;

    private String roomCapacity;


    private BigDecimal roomPrice;

    @Column(name="description")
    private String roomDescription;

    private String roomStatus;

    @Column(name = "room_image")
    private String roomImage;

    public Room(Long hotelId, String roomName, String roomType, String roomCapacity,
                BigDecimal roomPrice, String roomDescription, String roomStatus, String roomImage) {
        this.hotelId = hotelId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
        this.roomPrice = roomPrice;
        this.roomDescription = roomDescription;
        this.roomStatus = roomStatus;
        this.roomImage = roomImage;
    }
}
