package com.example.HotelDemo.Model.Dto;


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
