package com.example.hotelDemo.controller;


import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
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

    //add a new user
    @PostMapping("/add")

    public void addNewUser(@RequestBody @Validated UserDto userDto) {
        userService.addNewUser(userDto);
    }

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
    }

    //update a user
    @PutMapping("/update")

    public void updateUser(@RequestBody @Validated UserDto userDto) {
        userService.updateUser(userDto);
    }

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
    }
}
