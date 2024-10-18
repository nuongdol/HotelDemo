package com.example.hotelDemo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "room")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long roomId;

    @Column(name = "hotel_id")
    Long hotelId;

    @Column(name = "name")
    private String roomName;

    @Column(name = "type")
    private String roomType;

    @Column(name = "capacity")
    private String roomCapacity;

    @Column(name = "price")
    private BigDecimal roomPrice;

    @Column(name="description")
    private String roomDescription;

    @Column(name = "status")
    private String roomStatus;

    @Column(name = "image")
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
