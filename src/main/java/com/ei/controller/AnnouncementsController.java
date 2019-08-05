package com.ei.controller;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

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

@Controller
public class AnnouncementsController {
    
    @Autowired
    private AnnouncementService AnnouncementService;
    
    
    @GetMapping(value = { "/announcementsManage" })
    public ModelAndView announcementsManage(@ModelAttribute("announcementForm") AnnouncementForm aForm) {
        // Prepopulate a value to the form
        aForm.setDescription("THIS IS A TEST");

        // Creating an announcement list
        List<Announcement> announcementsList = new ArrayList<>();
        // Add an item to the announcement list
        announcementsList = AnnouncementService.getAllActiveAnnouncements(true);
        System.out.println("announcementsList LIST: " + announcementsList);

        // Creating a list of all Announcement Colors
        List<AnnouncementColor> colorList = Arrays.asList(AnnouncementColor.values());
        System.out.println("COLOR LIST: " + colorList);

        // Create the mav
        ModelAndView mav = new ModelAndView("announcementsManage");

        // Adding the list to the mav so HTML can use View purposes
        mav.addObject("announcementsList", announcementsList);

        // Adding the list to the mav so HTML can use
        mav.addObject("colorList", colorList);

        return mav;

    }

    @PostMapping(value = { "/announcementsManage" })
    public String announcementsManage(@ModelAttribute("announcementForm") AnnouncementForm aForm,
            BindingResult bindingResult) {

        AnnouncementService.saveAnnouncement(aForm);
        return "redirect:/AnnouncementsManage";
    }
}
