package com.example.hotelDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employees_id")
    private Long employeesId;
    @Column(name = "employees_first_name")
    private String employeesFirstName;
    @Column(name = "employees_last_name")
    private String employeesLastName;
    @Column(name = "employees_designation")
    private String employeesDesignation;
    @Column(name = "employees_email_address")
    private String employeesEmailAddress;
    @Column(name = "employees_contract_number")
    private String employeesContractNumber;
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "addresses_id")
    private Long addressesId;
    @Column(name = "hotel_id")
    private Long hotelId;
    @Column(name = "deleted_flag")
    private Integer deletedFlag;
}
