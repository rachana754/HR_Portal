package com.ei.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.dao.AnnouncementDAO;
import com.ei.form.AnnouncementForm;
import com.ei.model.Announcement;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDAO AnnouncementDAO;

    public List<Announcement> getAllActiveAnnouncements(boolean isActive) {
        return AnnouncementDAO.findByIsActive(isActive);
    }

    public Announcement saveAnnouncement(AnnouncementForm a) {
        Announcement Announcement = new Announcement();
        Announcement.setSubject(a.getSubject());
        Announcement.setDescription(a.getDescription());
        Announcement.setColor(a.getSelectedColor());
        Announcement.setLink(a.getLink());
        Date date = new Date();
        Announcement.setCreateDate(date);
        Announcement.setDeleteDate(date);
        Announcement.setActive(true);
        return AnnouncementDAO.save(Announcement);
    }

}
