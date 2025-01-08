package com.example.hotelDemo.security.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private Long userId;
    private String userName;
    public static UserDTO from(User user){
        return UserDTO.builder()//corrected the reference to the builder
            .userId(user.getUserId())
            .userName(user.getUsername())
            .build();
    }

}
