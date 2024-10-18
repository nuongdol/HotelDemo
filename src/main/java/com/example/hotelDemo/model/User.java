package com.example.hotelDemo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    Long userId;

    @Column(name = "name")
    String userName;

    String password;

    String email;

    String phone;

    String address;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Column(name = "create_at")
    @CreatedDate
    protected Date createAt;






}

