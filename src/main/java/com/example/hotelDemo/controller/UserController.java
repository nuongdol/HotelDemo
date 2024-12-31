package com.example.hotelDemo.controller;


import com.example.hotelDemo.exception.UserAlreadyExistException;
import com.example.hotelDemo.model.User;
import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import com.example.hotelDemo.model.dto.UserDto;
import com.example.hotelDemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/create")
    @Operation(description = "add a new user")
    public void addNewUser(@RequestBody UserDto userDto) {
        userService.addNewUser(userDto);
    }

    @GetMapping("/all-lst-users")
    @Operation(description = "get list users")
    public List<UserDto> getAllLstUser() {
        return userService.getAllLstUser();
    }

    @GetMapping("/lst-user/{userId}")
    @Operation(description = "get a user by userId")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/update")
    @Operation(description = "update a user")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
    }


    @DeleteMapping("/{userId}")
    @Operation(description = "delete a user by userId")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserByUserId(userId);
    }


    @GetMapping("/lst-rooms/{userId}")
    @Operation(description = "get room list and booking voucher by userId")
    public List<IUserBookingRoomDto> getAllLstRoomWithBookingVoucher(@PathVariable Long userId) {
        return userService.getAllLstRoomWithBookingVoucherByUserId(userId);
    }

    /*sign-up link: */
    @GetMapping("/register")
    @Operation(description = "show register form")
    public void register(WebRequest request, Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
    }

    //check that the account doesn't already exist
    @PostMapping("/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
        HttpServletRequest request, Errors errors) throws UserAlreadyExistException {
            userService.registerNewUserAccount(userDto);
            //ModelAndView sending model data(user) tied to the view.
        return new ModelAndView("successRegister", "user", userDto);
    }
}
