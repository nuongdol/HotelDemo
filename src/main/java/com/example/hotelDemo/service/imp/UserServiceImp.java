package com.example.hotelDemo.service.imp;

import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.User;
import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
import com.example.hotelDemo.model.dto.UserDto;
import com.example.hotelDemo.repository.UserRepository;
import com.example.hotelDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addNewUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.save(user);
    }

    @Override
<<<<<<< HEAD
    public List<UserDto> getAllLstUser() {
=======
    public List<UserDto> getAllUsers() {
>>>>>>> 17fb990 (eight commit)
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
<<<<<<< HEAD
    public UserDto getUserByUserId(Long userId) {
        Optional<User> user = Optional.of(userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with id " + userId + " not found")));
=======
    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
>>>>>>> 17fb990 (eight commit)
        UserDto userDto = new UserDto();
        user.ifPresent(value -> BeanUtils.copyProperties(value, userDto));
        return userDto;
    }

    @Override
    public void updateUser(UserDto userDto) {
<<<<<<< HEAD
        Optional<User> user = Optional.of(userRepository.findById(userDto.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + userDto.getUserId() + " not found")
        ));
        User userUpdate = user.get();
        BeanUtils.copyProperties(userDto, userUpdate);
=======
        Optional<User> user = userRepository.findById(userDto.getUserId());
        User userUpdate = new User();
        if(user.isPresent()){
            userUpdate = user.get();
            BeanUtils.copyProperties(userDto, userUpdate);
        }else {
            throw new ResourceNotFoundException("User not found");
        }
>>>>>>> 17fb990 (eight commit)
        userRepository.save(userUpdate);
    }

    @Override
<<<<<<< HEAD
    public void deleteUserByUserId(Long userId) {
        Optional<User> user = Optional.of(userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with id " + userId + " not found")));
        userRepository.deleteById(user.get().getUserId());
    }

    @Override
    public List<IUserBookingRoomDto> getAllLstRoomWithBookingVoucherByUserId(Long userId) {
        if (userRepository.existsById(userId)) {
            return userRepository.findRoomWithBookingVoucherByUserId(userId);
=======
    public void deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            userRepository.deleteById(userId);
>>>>>>> 17fb990 (eight commit)
        }else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    @Override
    public List<IUserBookingRoomDto> getBookingRoomByUserId(Long userId) {
        return userRepository.findBookingAndRoomByUserId(userId);
    }
}
