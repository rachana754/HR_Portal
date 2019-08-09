package com.ei.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ei.enums.AnnouncementColor;
import com.ei.form.AlertForm;
import com.ei.form.AnnouncementForm;
import com.ei.model.Alert;
import com.ei.model.Announcement;
import com.ei.service.AnnouncementService;

@Controller
public class AnnouncementsController {
    
    @Autowired
    private AnnouncementService announcementService;
    
    
    @GetMapping(value = { "/announcementsManage" })
    public ModelAndView announcementsManage(@ModelAttribute("announcementForm") AnnouncementForm aForm) {
        // Creating an announcement list
        List<Announcement> announcementsList = new ArrayList<>();
        
        // Add an item to the announcement list
        announcementsList = announcementService.getAllActiveAnnouncements(true);

        // Creating a list of all Announcement Colors
        List<AnnouncementColor> colorList = Arrays.asList(AnnouncementColor.values());

        // Create the mav
        ModelAndView mav = new ModelAndView("announcementsManage");

        // Adding the list to the mav so HTML can use View purposes
        mav.addObject("announcementsList", announcementsList);

        // Adding the list to the mav so HTML can use
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
