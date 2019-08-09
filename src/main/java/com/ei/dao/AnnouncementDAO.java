package com.ei.dao;

import java.util.List; 

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ei.model.Alert;
import com.ei.model.Announcement;


@Repository
@Transactional
public interface AnnouncementDAO extends JpaRepository<Announcement, Integer> {

    /**
     * Returns the Announcements by active state
     * 
     * @param isActive
     *            - true is for all active Announcements and false is for all inactive Announcements
     * @return returns all active/inactive Announcement list if exists or empty list if none.
     */
    List<Announcement> findByIsActive(boolean isActive);

    /**
     * Saves the Announcement from Announcement Form to Database
     * 
     * @param AnnouncementForm
     *            - user filled form is the parameter to be saved
     * @return returns the newly added Announcement if all parameters are supplied correctly else gives errors.
     */
    @SuppressWarnings("unchecked")
    Announcement save(Announcement a);
    
    /**
     * Returns the Announcement with given id
     * 
     * @param id
     *            - id of the Announcement to be found
     * @return returns the Announcement with id found in database or null if not found.
     */
    Announcement findById(int id);

}