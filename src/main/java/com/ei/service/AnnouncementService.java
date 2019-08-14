package com.ei.service;

import java.util.List;

/**
 * Allows access to DAO methods for Announcements
 * @author sjean-baptiste
 */

import com.ei.form.AnnouncementForm;
import com.ei.model.Announcement;

public interface AnnouncementService {

    /**
     * Returns the Announcement with given id
     * 
     * @param id
     *            - id of the Announcement to be found
     * @return returns the Announcement with id found in database or null if not found
     */
    public Announcement findById(int id);

    /**
     * Returns the Announcements by active state
     * 
     * @return returns all active Announcement list if exists or empty list if none.
     */
    public List<Announcement> getAllActiveAnnouncements();
    
    /**
     * Returns the Announcements by inactive state
     * 
     * @return returns all inactive Announcement list if exists or empty list if none.
     */
    public List<Announcement> getAllInactiveAnnouncements();
    

    /**
     * Saves the Announcement from Announcement Form to Database
     * 
     * @param AnnouncementForm
     *            - user filled form is the parameter to be saved
     * @return returns the newly added Announcement if all parameters are supplied correctly else gives errors.
     */
    public Announcement saveAnnouncement(AnnouncementForm a);


    /**
     * 
     * @param a
     *            - Announcement to be deleted
     * @return returns true if Announcement is successfully made inactive or false if not. Here deletion is happening by making
     *         them in active.
     */
    public boolean inActivateAnnouncement(AnnouncementForm a);
    
}
