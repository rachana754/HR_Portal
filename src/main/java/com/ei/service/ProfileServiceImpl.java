package com.ei.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.dao.ProfileDAO;
import com.ei.model.Profile;

/**
 * Implementation of the ProfileServic interface.
 * 
 * @author bstout
 *
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDAO profileDAO;

    public Profile getByUsername(String username) {
        return profileDAO.getByUsername(username);
    }

    public String getEmailByUsername(String username) {
        // get the profile by username
        Profile profile = this.getByUsername(username);
        if (profile != null) {
            // return the email from the profile
            return profile.getEmail().toString();
        }
        // return empty String if not found
        return "";
    }

}
