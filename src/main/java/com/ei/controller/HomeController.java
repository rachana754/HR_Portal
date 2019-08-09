package com.ei.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ei.enums.AnnouncementColor;
import com.ei.form.AnnouncementForm;
import com.ei.form.TellHRForm;
import com.ei.model.Alert;
import com.ei.model.Announcement;
import com.ei.service.AlertService;
import com.ei.service.AnnouncementService;

import com.ei.constants.ConfigNames;
import com.ei.service.ConfigService;
import com.ei.constants.ConfigNames;
import com.ei.dao.ConfigSpecificationDAO;
import com.ei.dao.MessageDAO;
import com.ei.service.ConfigServiceImpl;
import com.ei.service.MessageService;

@Controller
public class HomeController {

    @Autowired
    private AlertService alertService;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ConfigService configService;
    

    /**
     * This method makes sure everything is available and set up for when the home page is loaded
     */
    @RequestMapping(value = { "/home" })
    public ModelAndView home(@ModelAttribute("tellHR") TellHRForm tForm) {
        ModelAndView mav = new ModelAndView("home");
        List<Alert> alertsList = alertService.getAllActiveAlerts(true);
        mav.addObject("alertsList", alertsList);
        // Creating an announcement list
        List<Announcement> announcementsList = new ArrayList<>();
        // Add an item to the announcement list
        announcementsList = announcementService.getAllActiveAnnouncements(true);

        boolean displayTellHR = Boolean.parseBoolean(configService.findByName(ConfigNames.Home.TellHR.DISPLAY).getDefaultValue());
        mav.addObject("displayTellHR", displayTellHR);
        
        if(displayTellHR) {
        List<String> allowedSubjects = Arrays.asList(
                    configService.findByName(ConfigNames.Home.TellHR.ALLOWED_SUBJECTS).getDefaultValue().split(","));
        mav.addObject("allowedSubjects", allowedSubjects);
        }
        

        // Creating a list of all Announcement Colors
        List<AnnouncementColor> colorList = Arrays.asList(AnnouncementColor.values());

        // Adding the list to the mav so HTML can use View purposes
        mav.addObject("announcementsList", announcementsList);

        // Adding the list to the mav so HTML can use
        mav.addObject("colorList", colorList);

        return mav;

    }

    /**
     * Handles submission of the the TellHR form and sends the information to the backend
     */
    @PostMapping(value = { "/home/tellHR" })
    public ModelAndView tellHR(@ModelAttribute("tellHR") TellHRForm tForm, BindingResult bindingResult) {
        messageService.saveMessage(tForm);
        return new ModelAndView("home");
    }

}
