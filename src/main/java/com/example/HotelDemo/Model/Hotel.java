package com.example.HotelDemo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int HotelId;
    @Column(name = "name")
    private String HotelName;
    @Column(name = "address")
    private String HotelAddress;
    @Column(name="city")
    private String HotelCity;
}
