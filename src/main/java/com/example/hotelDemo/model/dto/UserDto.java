package com.example.hotelDemo.model.dto;


import com.example.hotelDemo.customAnnotation.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    @ValidEmail//self custom validation to check email validity
    private String email;

    private String phone;

    private String address;

    @NotNull
    @NotEmpty
    private String password;

    String matchingPassword;
}
