package com.example.hotelDemo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Date;


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

    @Column(name = "created_at")
    @CreatedDate
    protected Date createAt;

    @Column(name = "delete_flag")
    private Integer deleteFlag;




}
