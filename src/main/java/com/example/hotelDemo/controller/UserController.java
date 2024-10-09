package com.example.hotelDemo.controller;


import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import com.example.hotelDemo.model.dto.UserDto;
import com.example.hotelDemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final UserService userService;


    @PostMapping("/create")
    @Operation(description = "add a new user")
    public void addNewUser(@RequestBody @Validated UserDto userDto) {
        userService.addNewUser(userDto);
    }

    @GetMapping("/get-all-lst-user")
    @Operation(description = "get list user")
    public List<UserDto> getAllLstUser() {
<<<<<<< HEAD
=======
//        return userService.getAllLstUser().stream().map(user -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());
>>>>>>> e32e7fb (twelve)
        return userService.getAllLstUser();
    }

    @GetMapping("/lst-user/{userId}")
    @Operation(description = "get a user by userId")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/update")
    @Operation(description = "update a user")
    public void updateUser(@RequestBody @Validated UserDto userDto) {
        userService.updateUser(userDto);
    }


    @DeleteMapping("/delete/{userId}")
    @Operation(description = "delete a user by userId")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserByUserId(userId);
    }


    @GetMapping("/get-lst-room/{userId}")
    @Operation(description = "get room list and booking voucher by userId")
    public List<IUserBookingRoomDto> getAllLstRoomWithBookingVoucher(@PathVariable Long userId) {
        return userService.getAllLstRoomWithBookingVoucherByUserId(userId);
    }
}
