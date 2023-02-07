package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.User;

public interface UserDAOInterface {

    // what features would i need?
        // create a new user
        // be able to pull list of all users
        // be able to pull user by id
        // be able to update a user location
        // i think that's it!

    // create new user
    User createUser(User newUser);

    // retrieve all users
    List<User> getAllUsers();

    // retrieve user by id
    List<User> getUserById(int id);

    // retrieve user by username
    List<User> getUserByUsername(String username);

    // update user location
    User updateLocation(User updatedZipCode);
    
}
