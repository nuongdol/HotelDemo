package com.example.hotelDemo.model;

import jakarta.persistence.*;

@Entity
public class MappingUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "user_id")
    private String userId;
}
