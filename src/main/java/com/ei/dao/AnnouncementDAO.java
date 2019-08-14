package com.ei.dao;

import java.util.List; 

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ei.model.Announcement;

/**
 * Management and querying of for Announcement (associated with announcements table)
 * @author sjean-baptiste
 */

@Repository
@Transactional
public interface AnnouncementDAO extends JpaRepository<Announcement, Integer> {
    
    /**
     * Returns the Announcement with given id
     * 
     * @param id
     *            - id of the Announcement to be found
     * @return returns the Announcement with id found in database or null if not found.
     */
    Announcement findById(int id);

    /**
     * Returns the Announcements by active state
     * 
     * @param isActive
     *            - true for all active Announcements and false for all inactive Announcements
     * @return returns Announcement list if exists or empty list if none found
     */
    List<Announcement> findByIsActive(boolean isActive);

    /**
     * Saves the Announcement to the DB
     * 
     * @param Announcement
     *            - Announcement to be saved
     * @return returns the newly saved Announcement
     */
    @SuppressWarnings("unchecked")
    Announcement save(Announcement a);

}