package com.ei.controller;

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
import com.ei.form.TellHRForm;
import com.ei.model.Alert;
import com.ei.model.Announcement;
import com.ei.service.AlertService;
import com.ei.service.AnnouncementService;

import com.ei.constants.ConfigNames;
import com.ei.service.ConfigService;
import com.ei.service.MessageService;

/**
 * Communicates with the Home page and handles sending information to and receiving information from the front end.
 * @author acox, sjean-baptiste, rrevuri
 */

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
        // Populate announcement list from DB
        List<Announcement> announcementsList = announcementService.getAllActiveAnnouncements();
        // Populate announcement colors from possible values of AnnoucementColor enum class
        List<AnnouncementColor> colorList = Arrays.asList(AnnouncementColor.values());

        // Populate alert list from DB
        List<Alert> alertsList = alertService.getAllActiveAlerts(true);

        
        boolean displayTellHR = Boolean
                .parseBoolean(configService.findByName(ConfigNames.Home.TellHR.DISPLAY).getDefaultValue());
        if (displayTellHR) {
            // Populate allowed subjects from config table in DB
            List<String> allowedSubjects = Arrays.asList(
                    configService.findByName(ConfigNames.Home.TellHR.ALLOWED_SUBJECTS).getDefaultValue().split(","));
            mav.addObject("allowedSubjects", allowedSubjects);
        }

        // Add all objects to mav for HTML use
        mav.addObject("announcementsList", announcementsList);
        mav.addObject("colorList", colorList);
        mav.addObject("alertsList", alertsList);
        mav.addObject("displayTellHR", displayTellHR);

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
