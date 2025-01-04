package com.example.hotelDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addresses_id")
    private Long addressesId;
    @Column(name = "addresses_line1")
    private String addressesLine1;
    @Column(name = "addresses_line2")
    private String addressesLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "zip_code")
    private String zipcode;
    @Column(name = "deleted_flag")
    private Integer deleted_flag;
}
