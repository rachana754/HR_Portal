package com.ei.service;

import com.ei.model.Profile;

/**
 * Methods within this are used to access Profile data
 * 
 * @author bstout
 *
 */
public interface ProfileService {

    /**
     * Returns the profile by its username.
     * 
     * @param username
     * @return Profile
     */
    public Profile getByUsername(String username);

    /**
     * Returns the profile email address by its username. Returns empty String if not found.
     * 
     * @param username
     * @return email address
     * @return " " empty string
     */
    public String getEmailByUsername(String username);

}
