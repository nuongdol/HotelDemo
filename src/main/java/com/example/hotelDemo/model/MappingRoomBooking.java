package com.example.hotelDemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "mapping_room_booking")
@NoArgsConstructor
@AllArgsConstructor
public class MappingRoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "booking_id")
    private Long bookingId;

    public MappingRoomBooking(Long roomId, Long bookingId) {
        this.roomId = roomId;
        this.bookingId = bookingId;
    }

}
