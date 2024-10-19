package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
import com.example.hotelDemo.model.dto.UserDto;
import java.util.List;


public interface UserService {

    void addNewUser(UserDto userDto);

    List<UserDto> getAllLstUser();

    UserDto getUserByUserId(Long userId);

    void updateUser(UserDto userDto);

    void deleteUserByUserId(Long userId);

    List<IUserBookingRoomDto> getAllLstRoomWithBookingVoucherByUserId(Long userId);
}
