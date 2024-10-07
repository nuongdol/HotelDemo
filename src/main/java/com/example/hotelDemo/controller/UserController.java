package com.example.hotelDemo.controller;


import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
<<<<<<< HEAD
import com.example.hotelDemo.model.dto.RoomHotelDto;
=======
>>>>>>> 17fb990 (eight commit)
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

<<<<<<< HEAD
=======
    //add a new user
    @PostMapping("/add")
>>>>>>> 17fb990 (eight commit)

    @PostMapping("/create")
    @Operation(description = "add a new user")
    public void addNewUser(@RequestBody @Validated UserDto userDto) {
        userService.addNewUser(userDto);
    }

<<<<<<< HEAD
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
=======
    //get all users
    @GetMapping("/get-all")

    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());

    }

    //get a user
    @GetMapping("/get/{id}")

    public UserDto getUserById(@PathVariable(name = "id") Long userId) {
        return userService.getUserById(userId);
>>>>>>> 17fb990 (eight commit)
    }

    @PutMapping("/update")
<<<<<<< HEAD
    @Operation(description = "update a user")
=======

>>>>>>> 17fb990 (eight commit)
    public void updateUser(@RequestBody @Validated UserDto userDto) {
        userService.updateUser(userDto);
    }

<<<<<<< HEAD

    @DeleteMapping("/delete/{userId}")
    @Operation(description = "delete a user by userId")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserByUserId(userId);
    }


    @GetMapping("/get-lst-room/{userId}")
    @Operation(description = "get room list and booking voucher by userId")
    public List<IUserBookingRoomDto> getAllLstRoomWithBookingVoucher(@PathVariable Long userId) {
        return userService.getAllLstRoomWithBookingVoucherByUserId(userId);
=======
    //delete a user
    @DeleteMapping("/delete/{id}")

    public void deleteUserById(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
    }

    //get detail
    @GetMapping("/get-detail/{id}")
    @Operation(description = "get detail room and booking by using userId")
    public List<IUserBookingRoomDto> getUserBookingRoom(@PathVariable(name = "id") Long userId) {
        return userService.getBookingRoomByUserId(userId);
>>>>>>> 17fb990 (eight commit)
    }
}
