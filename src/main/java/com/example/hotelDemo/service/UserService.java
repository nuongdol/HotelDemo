package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.UserDto;
import java.util.List;


public interface UserService {

    void addNewUserService(UserDto userDto);

    List<UserDto> getAllUsersService();

    UserDto getUserByIdService(Long userId);

    void updateUserService(UserDto userDto);

    void deleteUserService(Long userId);
}
