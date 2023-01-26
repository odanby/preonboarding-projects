package com.tabitha.utils;

import java.util.regex.Pattern;

import com.tabitha.entities.User;

public class UserBusinessRules {

    // registration

        // checking email is in email format
        // this method i'm not sure if it'll work yet
        public static boolean patternMatches(String emailAddress, String regexPattern) {
            return Pattern.compile(regexPattern)
            .matcher(emailAddress)
            .matches();

            // this is the regexPattern = "^(.+)@(\\S+)$";
        }

        // limit zip code to 5 characters
        public boolean checkZipCodeLength(User zipcodeToCheck){
            if(zipcodeToCheck.getZip_code() > 5){
                return false;
            } else {
                return true;
            }
        }


        // limit password entry to 50 characters
        public boolean checkPasswordLength(User passwordToCheck){
            if(passwordToCheck.getUser_password().length() > 50){
                return false;
            } else {
                return true;
            }
        }

        // limit username entry to 50 characters
        public boolean checkUsernameLength(User usernameToCheck){
            if(usernameToCheck.getUsername().length() > 50){
                return false;
            } else {
                return true;
            }
        }

        // limit first name entry to 50 characters
        public boolean checkFirstNameLength(User firstNameToCheck){
            if(firstNameToCheck.getFirst_name().length() > 50){
                return false;
            } else {
                return true;
            }
        }

        // ensures creating username doesn't match another username
        public boolean checkUsernameMatch(User userToCheck, String actualUsername){
            if(userToCheck.getUsername().equals(actualUsername)){
                return false;
            } else {
                return true;
            }
        }

        // ensures creating email doesn't match another email
        public boolean checkEmailMatch(User emailToCheck, String actualEmail){
            if(emailToCheck.getEmail().equals(actualEmail)){
                return false;
            } else {
                return true;
            }
        }

    // login
        public boolean checkLoginCredentials(User credentialsToCheck, String actualUsernameCredential, String actualPasswordCredential){
            if(credentialsToCheck.getUsername().equals(actualUsernameCredential) && credentialsToCheck.getUser_password().equals(actualPasswordCredential)){
                return true;
            } else {
                return false;
            }
        }
}
