package com.example.hotelDemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long bookingId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "checkin_date")
    private LocalDate checkinDate;

    @Column(name = "checkout_date")
    private LocalDate checkoutDate;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "adults")
    private Integer numberOfAdults;

    @Column(name = "children")
    private Integer numberOfChildren;

    @Column(name = "total_guest")
    private Integer totalNumberOfGuest;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "status")
    private String bookingStatus;

<<<<<<< HEAD
=======




>>>>>>> 17fb990 (eight commit)
}
