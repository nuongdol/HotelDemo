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
    private Long RoomId;

    @Column(name = "booking_id")
    private Long BookingId;

    public MappingRoomBooking(Long roomId, Long bookingId) {
        RoomId = roomId;
        BookingId = bookingId;
    }

}
