package com.example.hotelDemo.controller;


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
    @Operation(summary = "add new User", description = "user exist")

    public void addNewUser(@RequestBody @Validated UserDto userDto) {
        userService.addNewUserService(userDto);
    }

    //get all users
    @GetMapping("/get-all")
    @Operation(summary = "get all users")

    public List<UserDto> getAllUsers() {
        return userService.getAllUsersService().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());

    }

    //get a user
    @GetMapping("/get/{id}")
    @Operation(summary = "get a user by Id")

    public UserDto getUserById(@PathVariable(name = "id") Long userId) {
        return userService.getUserByIdService(userId);
    }

    //update a user
    @PutMapping("/update")
    @Operation(summary = "update user by Id")

    public void updateUser(@RequestBody @Validated UserDto userDto) {
        userService.updateUserService(userDto);
    }

    //delete a user
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete user by Id")

    public void deleteUserById(@PathVariable(name = "id") Long userId) {
        userService.deleteUserService(userId);
    }
}
