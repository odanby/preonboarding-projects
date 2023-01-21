package com.tabitha.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String username;
    private String user_password;
    private String email;
    private String zip_code;

    // an empty constructor
    public User(){};

    // full constructor
    public User(
        int id,
        String first_name,
        String username,
        String user_password,
        String email,
        String zip_code){
            this.id = id;
            this.first_name = first_name;
            this.username = username;
            this.user_password = user_password;
            this.email = email;
            this.zip_code = zip_code;
        }
    
    // constructor without id
    public User(
        String first_name,
        String username,
        String user_password,
        String email,
        String zip_code){
            this.first_name = first_name;
            this.username = username;
            this.user_password = user_password;
            this.email = email;
            this.zip_code = zip_code;
        }

    // update location
    public User(
        int id,
        String zip_code
    ){
        this.id = id;
        this.zip_code = zip_code;
    }

    // getters

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getEmail() {
        return email;
    }

    public String getZip_code() {
        return zip_code;
    }
    
    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    // to string
    @Override
    public String toString() {
        return "User [id=" + id + ", first_name=" + first_name + ", username=" + username + ", user_password="
                + user_password + ", email=" + email + ", zip_code=" + zip_code + "]";
    }    
};