package com.example.hotelDemo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long hotelId;

    @Column(name = "name")
    String hotelName;

    @Column(name = "address")
    String hotelAddress;

    @Column(name = "city")
    String hotelCity;

    @Column(name = "image")
    String hotelImage;

    @Column(name = "status")
    String hotelStatus;

    @Column(name= "create_at")
    @CreatedDate
    protected Date createAt;

    @Column(name = "delete_flag")
    private String deleteFlag;

}
