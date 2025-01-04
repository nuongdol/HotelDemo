package com.example.hotelDemo.model;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    Long paymentId;
    @Column(name = "booking_id")
    Long bookingId;
    @Column(name = "amount")
    BigDecimal amount;
    @Column(name = "payment_date")
    Date paymentDate;
    @Column(name = "status")
    String status;
    @Column(name = "deleted_flag")
    Integer deletedFlag;
}
