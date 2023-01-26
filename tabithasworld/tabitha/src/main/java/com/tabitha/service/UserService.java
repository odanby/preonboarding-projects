package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.User;
import com.tabitha.exceptions.InvalidUser;
import com.tabitha.repository.UserDAOInterface;
import com.tabitha.utils.UserBusinessRules;

public class UserService implements UserServiceInterface {

    private UserDAOInterface userDao;
    private UserBusinessRules userBusinessRules;

    public UserService(UserDAOInterface userDao, UserBusinessRules userBusinessRules){
        this.userDao = userDao;
        this.userBusinessRules = userBusinessRules;
    }

    @Override
    public User loginUser(User loginUser) {
        List<User> userArray = this.userDao.getAllUsers();
        for(int x = 0; x < userArray.size(); x++){
            User pulledUser = userArray.get(x);
            if(this.userBusinessRules.checkLoginCredentials(pulledUser, loginUser.getUsername(), loginUser.getUser_password())){
                return loginUser;
            }
        }
        throw new InvalidUser("Incorrect login: please try again!");
    }

    @Override
    public User serviceCreateUser(User newUser) {
        boolean valCheck1 = this.userBusinessRules.checkFirstNameLength(newUser);
        boolean valCheck2 = this.userBusinessRules.checkUsernameLength(newUser);
        boolean valCheck3 = this.userBusinessRules.checkPasswordLength(newUser);
        boolean valCheck4 = this.userBusinessRules.checkEmailLength(newUser);
        boolean valCheck5 = this.userBusinessRules.checkZipCodeLength(newUser);

        if(valCheck1 && valCheck2 && valCheck3 && valCheck4 && valCheck5){
            List<User> userArray = this.userDao.getAllUsers();
            for(int x = 0; x < userArray.size(); x++){
                User pulledUser = userArray.get(x);
                if(!this.userBusinessRules.checkUsernameMatch(pulledUser, newUser.getUsername())){
                    throw new InvalidUser("Username already in use.");
                }
                if(!this.userBusinessRules.checkEmailMatch(pulledUser, newUser.getEmail())){
                    throw new InvalidUser("Email or username already in use.");
                }
                if(!this.userBusinessRules.patternMatches(newUser.getEmail(), "^(.+)@(\\S+)$")){
                    throw new InvalidUser("Invalid email addresss.");
                }
            }
            return this.userDao.createUser(newUser);
        } else {
            throw new InvalidUser("Could not create new user account.");
        }
    }

    @Override
    public List<User> serviceGetAllUsers() {
        return this.userDao.getAllUsers();
    }

    @Override
    public List<User> serviceGetUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public User serviceUpdateLocation(User updatedZipCode) {
        boolean valCheck1 = this.userBusinessRules.checkFirstNameLength(updatedZipCode);
        boolean valCheck2 = this.userBusinessRules.checkUsernameLength(updatedZipCode);
        boolean valCheck3 = this.userBusinessRules.checkPasswordLength(updatedZipCode);
        boolean valCheck4 = this.userBusinessRules.checkEmailLength(updatedZipCode);
        boolean valCheck5 = this.userBusinessRules.checkZipCodeLength(updatedZipCode);

        if(valCheck1 && valCheck2 && valCheck3 && valCheck4 && valCheck5){
            List<User> userArray = this.userDao.getAllUsers();
            for(int x = 0; x < userArray.size(); x++){
                User pulledUser = userArray.get(x);
                if(!this.userBusinessRules.checkUsernameMatch(pulledUser, updatedZipCode.getUsername())){
                    throw new InvalidUser("Username already in use.");
                }
                if(!this.userBusinessRules.checkEmailMatch(pulledUser, updatedZipCode.getEmail())){
                    throw new InvalidUser("Email or username already in use.");
                }
                if(!this.userBusinessRules.patternMatches(updatedZipCode.getEmail(), "^(.+)@(\\S+)$")){
                    throw new InvalidUser("Invalid email addresss.");
                }
            }
            return this.userDao.updateLocation(updatedZipCode);
        } else {
            throw new InvalidUser("Could not update zip code.");
        }
    }
    
}
