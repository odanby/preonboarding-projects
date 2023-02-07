package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.User;

public interface UserServiceInterface {
    
    // log in
    User loginUser(User loginUser);

    // register for new account
    User serviceCreateUser(User newUser);

    // retrieve all users
    List<User> serviceGetAllUsers();

    // retrieve user by id
    List<User> serviceGetUserById(int id);

    // retrieve user by username
    List<User> serviceGetUserByUsername(String username);

    // update user location
    User serviceUpdateLocation(User updatedZipCode);
}
