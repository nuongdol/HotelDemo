package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addNewUserService(User user);

    List<User> getAllUsers();
    
    User updateUserService(long userId, User user);

    void deleteUserService(long userId);

    User getUserByIdService(long userId);
}
