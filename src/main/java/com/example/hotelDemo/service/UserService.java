package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
import com.example.hotelDemo.model.dto.UserDto;
import java.util.List;


public interface UserService {

    void addNewUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    void updateUser(UserDto userDto);

    void deleteUser(Long userId);

    List<IUserBookingRoomDto> getBookingRoomByUserId(Long userId);
}
