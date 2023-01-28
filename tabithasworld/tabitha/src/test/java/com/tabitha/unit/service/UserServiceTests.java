package com.tabitha.unit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.tabitha.entities.User;
import com.tabitha.repository.UserDAO;
import com.tabitha.repository.UserDAOInterface;
import com.tabitha.service.UserService;
import com.tabitha.service.UserServiceInterface;
import com.tabitha.utils.UserBusinessRules;

public class UserServiceTests {

    public static UserDAOInterface userDao;
    public static UserServiceInterface userService;
    public static UserBusinessRules userBusinessRules;

    // mockito mock tests
    public static UserDAOInterface mockUserDao;
    public static UserBusinessRules mockUserRules;
    public static UserServiceInterface userServiceWithMocks;

    @BeforeClass
    public static void setup(){        

        userBusinessRules = new UserBusinessRules();
        userDao = new UserDAO();
        userService = new UserService(userDao, userBusinessRules);

        mockUserDao = Mockito.mock(UserDAO.class);
        mockUserRules = Mockito.mock(UserBusinessRules.class);
        userServiceWithMocks = new UserService(mockUserDao, mockUserRules);
    }
    
    // successful login
    @Test
    public void checkLoginCredentialsPositive(){
        User successUser = new User("lucatest", "test123");
        boolean result = userBusinessRules.checkLoginCredentials(successUser, "lucatest", "test123");
        Assert.assertTrue(result);
    }

    // username not correct login
    @Test
    public void incorrectUsernameLoginNegative(){
        User unsuccessUser = new User("incorrect username", "test123");
        boolean result = userBusinessRules.checkLoginCredentials(unsuccessUser, "lucatest", "test123");
        Assert.assertFalse(result);
    }

    // password not correct login
    @Test
    public void incorrectPasswordLoginNegative(){
        User unsuccessUser = new User("lucatest", "incorrect password");
        boolean result = userBusinessRules.checkLoginCredentials(unsuccessUser, "lucatest", "test123");
        Assert.assertFalse(result);
    }

    // neither username or pasword correct login
    @Test
    public void incorrectLoginNegative(){
        User unsuccessUser = new User("incorrect username", "incorrect password");
        boolean result = userBusinessRules.checkLoginCredentials(unsuccessUser, "lucatest", "test123");
        Assert.assertFalse(result);
    }

    // username does not exist
    @Test
    public void usernameDoesNotExist(){
        User nonExistUser = new User("Test", "nonmatch", "password", "email@gmail.com", 55555);
        boolean result = userBusinessRules.checkUsernameMatch(nonExistUser, "lucatest");
        Assert.assertTrue(result);
    }

    // username does exist
    @Test
    public void usernameDoesExist(){
        User existUser = new User("Test", "lucatest", "password", "email@gmail.com", 55555);
        boolean result = userBusinessRules.checkUsernameMatch(existUser, "lucatest");
        Assert.assertFalse(result);
    }

    // email does not exist
    @Test
    public void emailDoesNotExist(){
        User nonExistUser = new User("Test", "username", "password", "email@gmail.com", 55555);
        boolean result = userBusinessRules.checkEmailMatch(nonExistUser, "luca@gmail.com");
        Assert.assertTrue(result);
    }

    // email does exist
    @Test
    public void emailDoesExist(){
        User existUser = new User("Test", "lucatest", "password", "luca@gmail.com", 55555);
        boolean result = userBusinessRules.checkEmailMatch(existUser, "luca@gmail.com");
        Assert.assertFalse(result);
    }

    // email not in email format
    @Test
    public void incorrectEmailFormat(){
        User badEmail = new User("Emma", "emmail", "empass", "emmaemail.com", 11111);
        boolean result = userBusinessRules.patternMatches(badEmail.getEmail(), "^(.+)@(\\S+)$");
        Assert.assertFalse(result);
    }

    // zipcode exceeds 99999
    @Test
    public void zipcodeExceeds(){
        User badZip = new User("Zippy", "zippy", "zipass", "zip@gmail.com", 100000000);
        boolean result = userBusinessRules.checkZipCodeLength(badZip);
        Assert.assertFalse(result);
    }

    // password exceeds 50 characters
    @Test
    public void passwordExceeds(){
        User badPassword = new User("firstname", "username", "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword", "email@gmail.com", 55555);
        boolean result = userBusinessRules.checkPasswordLength(badPassword);
        Assert.assertFalse(result);
    }

    // username exceeds 50 characters
    @Test
    public void usernameExceeds(){
        User badUsername = new User("firstname", "usernameusernameusernameusernameusernameusernameusernameusernameusernameusername", "password", "email@gmail.com", 55555);
        boolean result = userBusinessRules.checkUsernameLength(badUsername);
        Assert.assertFalse(result);
    }

    // first name exceeds 50 characters
    @Test
    public void firstNameExceeds(){
        User badFirstName = new User("firstnamefirstnamefirstnamefirstnamefirstnamefirstnamefirstnamefirstnamefirstnamefirstnamefirstname", "username", "password", "email@gmail.com", 55555);
        boolean result = userBusinessRules.checkFirstNameLength(badFirstName);
        Assert.assertFalse(result);
    }

    // email exceeds 50 characters
    @Test
    public void emailExceeds(){
        User badEmail = new User("firstname", "username", "password", "emaiemaiemaiemaiemaiemaiemaiemaiemaiemaiemaiemaiemail@gmail.com", 55555);
        boolean result = userBusinessRules.checkEmailLength(badEmail);
        Assert.assertFalse(result);
    }

    // retrieve all users
    @Test
    public void getAllUsers(){
        List<User> result = userService.serviceGetAllUsers();
        Assert.assertNotNull(result);
    }
    
    // retrieve user by id
    @Test
    public void getAllUsersById(){
        List<User> result = userService.serviceGetUserById(1);
        Assert.assertNotNull(result);
    }

    // successful registration
    @Test
    public void succesfulRegistration(){
        User goodUser = new User("Servicia", "servicia", "servicetest", "service@gmail.com", 11111);
        
        // need to mock everything
        Mockito.when(mockUserRules.checkEmailLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkFirstNameLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkPasswordLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkUsernameLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkZipCodeLength(goodUser)).thenReturn(true);
        
        User greatUser = new User(-100, "Servicia", "servicia", "servicetest", "service@gmail.com", 11111);
        Mockito.when(mockUserDao.createUser(goodUser)).thenReturn(greatUser);
        
        User result = userServiceWithMocks.serviceCreateUser(goodUser);
        Assert.assertNotNull(result.getId());
    }

    // successful update user location
    @Test
    public void successfulUpdate(){
        User goodUser = new User("Servicia", "servicia", "servicetest", "service@gmail.com", 11111);

        Mockito.when(mockUserRules.checkEmailLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkFirstNameLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkPasswordLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkUsernameLength(goodUser)).thenReturn(true);
        Mockito.when(mockUserRules.checkZipCodeLength(goodUser)).thenReturn(true);

        User greatUser = new User(-100, "Servicia", "servicia", "servicetest", "service@gmail.com", 55555);
        Mockito.when(mockUserDao.updateLocation(goodUser)).thenReturn(greatUser);

        User result = userServiceWithMocks.serviceUpdateLocation(goodUser);
        Assert.assertNotNull(result.getZip_code());
    }

}
