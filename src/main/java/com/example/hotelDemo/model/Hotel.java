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
    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "address")
    private String hotelAddress;

    @Column(name="city")
    private String hotelCity;

    @Column(name = "hotel_image")
    private String hotelImage;
}
