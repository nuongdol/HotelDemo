package com.example.hotelDemo.model.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;

    private String userName;

    private String email;

    private String phone;

    private String address;

    private String password;

}
