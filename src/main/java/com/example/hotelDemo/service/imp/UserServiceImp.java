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
    public List<UserDto> getAllLstUser() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByUserId(Long userId) {
        Optional<User> user = Optional.of(userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with id " + userId + " not found")));
        UserDto userDto = new UserDto();
        user.ifPresent(value -> BeanUtils.copyProperties(value, userDto));
        return userDto;
    }

    @Override
    public void updateUser(UserDto userDto) {
        Optional<User> user = Optional.of(userRepository.findById(userDto.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + userDto.getUserId() + " not found")
        ));
        User userUpdate = user.get();
        BeanUtils.copyProperties(userDto, userUpdate);
        userRepository.save(userUpdate);
    }

    @Override
    public void deleteUserByUserId(Long userId) {
        Optional<User> user = Optional.of(userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with id " + userId + " not found")));
        userRepository.deleteById(user.get().getUserId());
    }

    @Override
    public List<IUserBookingRoomDto> getAllLstRoomWithBookingVoucherByUserId(Long userId) {
        if (userRepository.existsById(userId)) {
            return userRepository.findRoomWithBookingVoucherByUserId(userId);
        }else {
            throw new ResourceNotFoundException("User not found");
        }
    }
}
