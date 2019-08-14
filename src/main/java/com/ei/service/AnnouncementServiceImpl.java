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

    @Override
    public Announcement findById(int id) {
        return announcementDAO.findById(id);
    }

    public List<Announcement> getAllActiveAnnouncements() {
        return announcementDAO.findByIsActive(true);
    }

    public List<Announcement> getAllInactiveAnnouncements() {
        return announcementDAO.findByIsActive(false);
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
        String link = a.getLink();

        if (link != null && link != "" && link.length() != 0) {
            link = link.startsWith("https://") ? link : "https://" + link;
        }

        announcement.setLink(link);
        announcement.setColor(AnnouncementColor.valueOf(a.getSelectedColor()));

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
