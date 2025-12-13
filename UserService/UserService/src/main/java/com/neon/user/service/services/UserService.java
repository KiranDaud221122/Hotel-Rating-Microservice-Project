package com.neon.user.service.services;

import com.neon.user.service.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    // perform all user related operation

    //Create user
    User saveUser (User user);

    //get all user
    List<User> getAllUser();

    //get specific user from user_id
    User getUser(String userId);

    User updateUserById(String userId, User updatedUser);

    void deleteUserById(String userId);

}
