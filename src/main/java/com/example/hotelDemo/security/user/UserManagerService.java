package com.example.hotelDemo.security.user;

import java.text.MessageFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import com.example.hotelDemo.repository.UserRepository;

@Service
public class UserManagerService implements UserDetailsManager {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserDetails user) {
        ((User) user).setPassword(passwordEncoder.encode(user.getPassword()));
        //save the user in the repository
        userRepository.save((User) user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //fetch the user from the repository by username
        Optional<User> user = userRepository.findByUserName(username);
        //check if the user exists
        if(user.isEmpty()){
            throw new UsernameNotFoundException(MessageFormat.format("User with username {0} not found", username));
        }
        //return the userDetails extracted from the user entity
        return user.get();
    }
}
