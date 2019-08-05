package com.ei.service;

import java.util.List;

import com.ei.form.AnnouncementForm;
import com.ei.model.Announcement;

public interface AnnouncementService {

    /**
     * Returns the Announcements by active state
     * 
     * @param isActive
     *            - true is for all active Announcements and false is for all inactive Announcements
     * @return returns all active/inactive Announcement list if exists or empty list if none.
     */
    public List<Announcement> getAllActiveAnnouncements(boolean isActive);
    

    /**
     * Saves the Announcement from Announcement Form to Database
     * 
     * @param AnnouncementForm
     *            - user filled form is the parameter to be saved
     * @return returns the newly added Announcement if all parameters are supplied correctly else gives errors.
     */
    public Announcement saveAnnouncement(AnnouncementForm a);
}
