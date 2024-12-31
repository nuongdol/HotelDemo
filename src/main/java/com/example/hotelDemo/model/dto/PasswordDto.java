package com.example.hotelDemo.model.dto;

import com.example.hotelDemo.customAnnotation.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PasswordDto {

    private String oldPassword;

    private String token;

    @ValidEmail
    private String newPassword;
}
