package com.ei.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ei.model.Profile;

/**
 * This class is used to retrieve profile objects from the database.
 * 
 * @author bstout
 *
 */
@Repository
@Transactional
public interface ProfileDAO extends JpaRepository<Profile, Integer> {

    /**
     * Returns the profile object by its username. Returns and empty string is profile is not found.
     * 
     * @param username
     * @return
     */
    Profile getByUsername(String username);

}
