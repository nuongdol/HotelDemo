package com.example.HotelDemo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    @Column(name = "name")
    private String roomName;
    @Column(name = "type")
    private String roomType;
    @Column(name= "capacity")
    private String roomCapacity;
    @Column(name= "price")
    private String roomPrice;
    @Column(name="description")
    private String roomDescription;
    @Column(name="status")
    private String roomStatus;
}
