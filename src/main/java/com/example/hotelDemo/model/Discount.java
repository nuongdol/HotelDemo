package com.example.hotelDemo.model;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long discountId;
    @Column(name = "discount_rate")
    private BigDecimal discountRate;
    @Column(name = "start_month")
    private Date startMonth;
    @Column(name = "end_month")
    private Date endMonth;
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "deleted_flag")
    private Integer deletedFlag;
}
