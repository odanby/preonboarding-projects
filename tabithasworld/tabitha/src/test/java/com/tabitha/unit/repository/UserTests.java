package com.tabitha.unit.repository;

import org.junit.Test;

import com.tabitha.entities.User;
import com.tabitha.repository.UserDAO;
import com.tabitha.repository.UserDAOInterface;

import java.util.List;

import org.junit.Assert;

public class UserTests {

    public static UserDAOInterface userDao = new UserDAO();

    // TEST to create a new user - IT WORKS!
        // User createUser(User newUser);
    @Test
    public void createUser(){
        User testUser = new User(0, "Chef", "chefboyardee", "password321", "ravioli@gmail.com", "11111");
        User result = userDao.createUser(testUser);
        Assert.assertNotNull(result.getId());
    }

    // TEST to retrieve all users - IT WORKS!
        // List<User> getAllUsers();
    @Test
    public void getAllUsers(){
        List<User> userList = userDao.getAllUsers();
        Assert.assertTrue(userList.size() >= 2);
    }

    // TEST to retrieve a user by id - IT WORKS!
        // List<User> getUserById(int id);
    @Test
    public void getUserById(){
        List<User> result = userDao.getUserById(1);
        Assert.assertNotNull(result);
    }

    // TEST to update a user location - IT WORKS!
        // User updateLocation(User updatedZipCode);
    @Test
    public void updateLocation(){
        User updatedLocation = new User(2, "Chef", "chefboyardee", "password321", "ravioli@gmail.com", "11112");
        User result = userDao.updateLocation(updatedLocation);
        Assert.assertEquals("11112", result.getZip_code());
    }

}