package com.example.HotelDemo.Service.imp;

import com.example.HotelDemo.Model.User;
import com.example.HotelDemo.Repository.UserRepository;
import com.example.HotelDemo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public void addNewUserService(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserService(long userId, User userRequest) {
        Optional<User> user = userRepository.findById(userId);
        User user1 = new User();
        if (user.isPresent()) {
            user1 = user.get();
        }
           user1.setUserName(userRequest.getUserName());
           user1.setPassword(userRequest.getPassword());
           user1.setEmail(userRequest.getEmail());
           user1.setPhone(userRequest.getPhone());
           user1.setAddress(userRequest.getAddress());
        return userRepository.save(user1);

    }

    @Override
    public void deleteUserService(long userId) {
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        userRepository.delete(user);
    }

    @Override
    public User getUserByIdService(long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }
}
