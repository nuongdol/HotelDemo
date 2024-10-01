package com.example.HotelDemo.Controller;

import com.example.HotelDemo.Exception.CheckoutUser;
import com.example.HotelDemo.Model.User;
import com.example.HotelDemo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    //add a new user
    @PostMapping("/add/new-user")
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        if(user != null){
            User add = userService.addUser(user);
            return ResponseEntity.ok(add);
        }
        return ResponseEntity.badRequest().build();
    }
    //get all users
    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() throws IOException, SQLException {
        List<User> getAll = userService.getAllUsers();
        return ResponseEntity.ok(getAll);
    }
    //get a user
    @GetMapping("/get-a-user/{id}")
    public ResponseEntity<?> getAUser(@PathVariable(name = "id") Integer idUser) throws IOException, SQLException{
        try{
            User user = userService.getAUser(idUser);
            return ResponseEntity.ok(user);

        }catch (CheckoutUser e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //update a user
    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") Integer idUser, @RequestBody User user)
            throws IOException, SQLException{
        User updateUser = userService.findUserByIdUser(idUser);
        if(updateUser.getUserName() != user.getUserName() || updateUser.getUserName() == null){
            updateUser.setUserName(user.getUserName());
        }
        if(updateUser.getAddress() == null || updateUser.getAddress() != user.getAddress()){
           updateUser.setAddress(user.getAddress());
        }
        if(updateUser.getEmail() == null || updateUser.getEmail() != user.getEmail()){
            updateUser.setUserName(user.getUserName());
        }
        if(updateUser.getPhone() == null || updateUser.getPhone() != user.getPhone()){
           updateUser.setPhone(user.getPhone());
        }
        if (updateUser.getPassword() == null || updateUser.getPassword() != user.getPassword()){
            updateUser.setPassword(user.getPassword());
        }

        return ResponseEntity.ok(updateUser);
    }
    //delete a user
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Integer idUser) throws IOException, SQLException{
        User deleteUser = userService.findUserByIdUser(idUser);
        if(deleteUser!= null){
            userService.deleteUser(deleteUser);
        }
        return ResponseEntity.ok("Delete user " + deleteUser);
    }
}
