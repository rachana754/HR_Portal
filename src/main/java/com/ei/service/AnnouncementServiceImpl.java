package com.ei.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.dao.AnnouncementDAO;
import com.ei.enums.AnnouncementColor;
import com.ei.form.AnnouncementForm;
import com.ei.model.Announcement;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDAO announcementDAO;

    public List<Announcement> getAllActiveAnnouncements(boolean isActive) {
        return announcementDAO.findByIsActive(isActive);
    }

    public Announcement saveAnnouncement(AnnouncementForm a) {
        Announcement announcement = new Announcement();
        
        boolean isEdit = a.getId() != null;
        
        // When editing (form has id), get the Announcement from DB as starting point
        if (isEdit) {
            announcement = this.findById(a.getId());
        }
        
        announcement.setSubject(a.getSubject());
        announcement.setDescription(a.getDescription());
        announcement.setLink(a.getLink());
        
        // Color is being selected
        String color = a.getSelectedColor();
        // if color is not selected set it to white by default otherwise the color has been selected
        if (color != null && !color.equalsIgnoreCase("-1")) {
            announcement.setColor(AnnouncementColor.valueOf(color));
        } else {
            announcement.setColor(AnnouncementColor.WHITE);
        }
        
        Date date = new Date();
        if (isEdit) {
            // save updated announcement
            announcement.setLastModifiedDate(date);
        } else {
            // save new announcement
            announcement.setCreateDate(new Date());
            announcement.setActive(true);
        }
        return announcementDAO.save(announcement);
    }

    @Override
    public Announcement findById(int id) {
        return announcementDAO.findById(id);
    }
    
    public boolean inActivateAnnouncement(AnnouncementForm a) {
        Announcement announcement = this.findById(a.getId());
        if (announcement != null) {
            announcement.setActive(false);
            announcement.setDeleteDate(new Date());
            announcementDAO.save(announcement);
            return true;
        }
        return false;
    }

    
}
