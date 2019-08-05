package com.ei.controller;

import java.util.ArrayList;
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

import com.ei.form.AlertForm;
import com.ei.model.Alert;
import com.ei.service.AlertService;

@Controller
public class AlertsController {

    @Autowired
    private AlertService alertService;

    @GetMapping(value = "/alertsManage")
    public ModelAndView alerts(@ModelAttribute("alertsForm") AlertForm aForm, BindingResult bindingResult) {
        List<Alert> alertsList = new ArrayList<>();
        alertsList = alertService.getAllActiveAlerts(true);
        ModelAndView mav = new ModelAndView("alertsManage");
        mav.addObject("alertsList", alertsList);
        return mav;
    }

    @GetMapping(value = "/editAlert/{id}")
    public ModelAndView edit(@ModelAttribute("alertsForm") AlertForm aForm, @PathVariable int id, Model model,
            BindingResult bindingResult) {
        Alert editAlert = alertService.findAlert(id);
        aForm.setId(editAlert.getId());
        aForm.setDescription(editAlert.getDescription());
        aForm.setSubject(editAlert.getSubject());
        ModelAndView mav = new ModelAndView("/alertsManage");
        // get current active alerts
        List<Alert> alertsList = alertService.getAllActiveAlerts(true);
        mav.addObject("alertsList", alertsList);
        // add form with prepopulated data from database
        mav.addObject("aForm", aForm);
        return mav;

    }

    @PostMapping(value = "/saveAlert")
    public String submit(@ModelAttribute("alertsForm") @Valid AlertForm aForm, BindingResult bindingResult) {
        alertService.saveAlert(aForm);
        return "redirect:/alertsManage";
    }

    @PostMapping(value = "/deleteAlert")
    public String delete(@ModelAttribute("alertsForm") @Valid AlertForm aForm) {
        alertService.inActivateAlert(aForm);
        return "redirect:/alertsManage";
    }
}