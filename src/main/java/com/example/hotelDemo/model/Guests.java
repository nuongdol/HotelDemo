package com.example.hotelDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Guests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guests_id")
    private Long guestsId;
    @Column(name = "guests_first_name")
    private String guestsFirstName;
    @Column(name = "guests_last_name")
    private String guestsLastName;
    @Column(name = "guests_contract_name")
    private String guestsContactName;
    @Column(name = "guests_email_address")
    private String guestsEmailAddress;
    @Column(name = "guests_credit_card")
    private String guestsCreditCard;
    @Column(name = "guests_id_proof")
    private String guestsIdProof;
    @Column(name = "addresses_id")
    private Long addressesId;
    @Column(name = "deleted_flag")
    private Integer deletedFlag;
}
