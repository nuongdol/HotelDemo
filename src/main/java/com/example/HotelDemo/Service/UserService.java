package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.User;
import com.example.HotelDemo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    @Override
    public User addUser(User user) {
        User newUser = new User(user.getUserId(), user.getUserName(), user.getPassword(),
                user.getEmail(), user.getPhone(), user.getAddress());
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAllUsers().forEach(user -> users.add(user));
        return users;
    }

    @Override
    public User getAUser(Integer idUser) {
        User user = new User();
        user = userRepository.findAUserById(idUser);
        return user;
    }

    @Override
    public User findUserByIdUser(Integer idUser) {
        User user = userRepository.findAUserById(idUser);
        return user;
    }

    @Override
    public void deleteUser(User deleteUser) {
        userRepository.deleteById(deleteUser.getUserId());

    }
}
