package com.ei.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ei.form.AlertForm;
import com.ei.model.Alert;
import com.ei.service.AlertService;

/**
 * Communicates with the Alerts page and handles sending information to and receiving information from the front end.
 * @author rrevuri
 */
@Controller
public class AlertsController {

    @Autowired
    private AlertService alertService;

    @GetMapping(value = "/alertsManage")
    public ModelAndView alerts(@ModelAttribute("alertsForm") AlertForm aForm) {
        List<Alert> alertsList  = alertService.getAllActiveAlerts(true);
        ModelAndView mav = new ModelAndView("alertsManage");
        mav.addObject("alertsList", alertsList);
        return mav;
    }

    @PostMapping(value = "/saveAlert")
    public String submit(@ModelAttribute("alertsForm") @Valid AlertForm aForm) {
        alertService.saveAlert(aForm);
        return "redirect:/alertsManage";
    }

    @PostMapping(value = "/deleteAlert")
    public String delete(@ModelAttribute("alertsForm") @Valid AlertForm aForm) {
        alertService.inActivateAlert(aForm);
        return "redirect:/alertsManage";
    }
    
}