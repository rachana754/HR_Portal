package com.ei.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ei.model.Profile;
import com.ei.service.Hasher;
import com.ei.service.ProfileService;

/**
 * Handles logic necessary for the Login page.
 * @author bstout
 */
@Component
public class LoginControllerHelper {

    @Autowired
    private ProfileService profileService;

    /**
     * Validates the username and password text fields. If invalid the fields are added to a list of invalid fields then
     * returns the list. If no fields are added, returns an empty list.
     * 
     * @param username
     * @param password
     * @return List<> of invalid fields
     * @throws Exception
     */
    public List<String> validateUsernameAndPassword(String username, String password) throws Exception {
        // get the profile object
        Profile user = profileService.getByUsername(username);

        List<String> invalidFields = new ArrayList<String>();
        // validate the username/password and add to list if not valid
        if (user == null || !username.equalsIgnoreCase(user.getUsername())) {
            invalidFields.add("username");
        }
        // validates password with a check method for hashed password
        if (user == null || !Hasher.check(password, user.getPassword())) {
            invalidFields.add("password");
        }
        return invalidFields;
    }

    /**
     * Takes in a string and validates it as an email address based off a regular expression. Returns true if it matches
     * a valid email, and returns false if not.
     * 
     * @param email
     * @return boolean value; true if valid, false if invalid
     */
    public boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
