package com.example.hotelDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HotelChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_chain_id")
    Long hotelChainId;
    @Column(name = "hotel_chain_name")
    String hotelChainName;
    @Column(name = "hotel_chain_contact_number")
    String hotelChainContactNumber;
    @Column(name = "hotel_chain_email_address")
    String hotelChainEmailAddress;
    @Column(name = "hotel_chain_website")
    String hotelChainWebsite;
    @Column(name = "hotel_chain_head_office_address")
    String hotelChainHeadOfficeAddress;
    @Column(name = "deleted_flag")
    Integer deletedFlag;
}
