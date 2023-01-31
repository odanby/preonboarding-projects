package com.tabitha.controllers;

import com.tabitha.entities.User;
import com.tabitha.exceptions.*;
import com.tabitha.service.UserServiceInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import io.javalin.http.Handler;

public class UserController {
    
    private UserServiceInterface userService;
    private Gson gson;

    public UserController(UserServiceInterface userService){
        this.userService = userService;
        this.gson = new Gson();
    };

    // log in
    public Handler loginUser = ctx -> {
        try {
            String json = ctx.body();

            User userToLogin = this.gson.fromJson(json, User.class);

            User result = this.userService.loginUser(userToLogin);

            String resultJson = this.gson.toJson(result);
            
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidUser e){
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        }
    };

    // register for new account
    public Handler createNewAccount = ctx -> {
        try {
            String json = ctx.body();
            User newUser = this.gson.fromJson(json, User.class);
            User result = this.userService.serviceCreateUser(newUser);
            String resultJson = this.gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(201);
        } catch (InvalidUser e){
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        }
    };

    // retrieve all users
    public Handler getAllUsers = ctx -> {
        try {
            List<User> user = this.userService.serviceGetAllUsers();
            if(user == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String userJSON = this.gson.toJson(user);
                ctx.result(userJSON);
                ctx.status(200);
            }
        } catch (InvalidUser e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // retrieve user by id
    public Handler getUserById = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            List<User> user = this.userService.serviceGetUserById(id);
            if(user == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String userJSON = gson.toJson(user);
                ctx.result(userJSON);
                ctx.status(200);
            }
        } catch (InvalidUser e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // update user location
    public Handler updateUser = ctx -> {
        try {
            String json = ctx.body();
            User updatedUser = gson.fromJson(json, User.class);
            updatedUser.setId(Integer.parseInt(ctx.pathParam("id")));
            User result = this.userService.serviceUpdateLocation(updatedUser);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidUser e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
}
