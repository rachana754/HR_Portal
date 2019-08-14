package com.ei.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ei.enums.AnnouncementColor;
import com.ei.form.AnnouncementForm;
import com.ei.model.Announcement;
import com.ei.service.AnnouncementService;

/**
 * Communicates with the Announcements page and handles sending information to and receiving information from the front end.
 * @author sjean-baptiste
 */

@Controller
public class AnnouncementsController {
    
    @Autowired
    private AnnouncementService announcementService;
    
    
    @GetMapping(value = { "/announcementsManage" })
    public ModelAndView announcementsManage(@ModelAttribute("announcementForm") AnnouncementForm aForm) {
        ModelAndView mav = new ModelAndView("announcementsManage");
        
        // Populate announcement list from DB
        List<Announcement> announcementsList = announcementService.getAllActiveAnnouncements();
        // Populate announcement colors from possible values of AnnoucementColor enum class
        List<AnnouncementColor> colorList = Arrays.asList(AnnouncementColor.values());
        
        aForm.setSelectedColor(AnnouncementColor.PURPLE.name());
        
        // Adding the list to the mav so HTML can use View purposes
        mav.addObject("announcementsList", announcementsList);
        mav.addObject("colorList", colorList);
        
        return mav;
    }

    @PostMapping(value = { "/saveAnnouncement" })
    public String submit(@ModelAttribute("announcementForm") @Valid AnnouncementForm aForm,
            BindingResult bindingResult) {
        announcementService.saveAnnouncement(aForm);
        return "redirect:/announcementsManage";
    }
    
    @PostMapping(value = "/deleteAnnouncement")
    public String delete(@ModelAttribute("announcementForm") @Valid AnnouncementForm aForm) {
        announcementService.inActivateAnnouncement(aForm);
        return "redirect:/announcementsManage";
    }
    
}
