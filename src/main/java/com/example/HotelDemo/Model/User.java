package com.example.HotelDemo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int UserId;
    @Column(name = "username")
    private String UserName;
    @Column(name = "password")
    private String Password;
    @Column(name = "email")
    private String Email;
    @Column(name="phone")
    private String Phone;
    @Column(name = "address")
    private String Address;
}

