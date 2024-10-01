package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Room;
import com.example.HotelDemo.Model.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    List<User> getAllUsers();

    User getAUser(Integer idUser);

    User findUserByIdUser(Integer idUser);

    void deleteUser(User deleteUser);
}
