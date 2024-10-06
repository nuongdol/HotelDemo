package com.example.HotelDemo.Controller;

import com.example.HotelDemo.Exception.CheckoutUser;
import com.example.HotelDemo.Model.Dto.UserDto;
import com.example.HotelDemo.Model.User;
import com.example.HotelDemo.Service.imp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final UserServiceImp userServiceImp;

    //add a new user
    @PostMapping("/add/new-user")
    public ResponseEntity<?> addNewUser(@RequestBody UserDto userDto) {
        if(userDto != null){

            //convert UserDto to entity
            User addNewUser = modelMapper.map(userDto, User.class);
            userServiceImp.addNewUserService(addNewUser);

            return ResponseEntity.ok().body(addNewUser);
        }
        return ResponseEntity.badRequest().build();
    }


    //get all users
    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDto>> getAllUsers() throws IOException, SQLException {

        //convert Entity to UserDto
        List<UserDto> allUsersDto = userServiceImp.getAllUsers().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(allUsersDto);
    }


    //get a user
    @GetMapping("/get-user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") long userId)
            throws IOException, SQLException{
        try{
            User user = userServiceImp.getUserByIdService(userId);

            //convert entity to Dto
            UserDto userDto = modelMapper.map(user, UserDto.class);

            return ResponseEntity.ok().body(userDto);

        }catch (CheckoutUser e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //update a user
    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") long userId, @RequestBody UserDto userDto)
            throws IOException, SQLException{

        //convert dto to entity
        User user = modelMapper.map(userDto, User.class);

        User user1 = userServiceImp.updateUserService(userId,user);

        //convert entity to dto
        UserDto userResponse = modelMapper.map(user1, UserDto.class);

        return ResponseEntity.ok().body(userResponse);
    }

    //delete a user
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(name = "id") long userId)
            throws IOException, SQLException{

      userServiceImp.deleteUserService(userId);
      return ResponseEntity.ok("Deleted user.");

    }
}
