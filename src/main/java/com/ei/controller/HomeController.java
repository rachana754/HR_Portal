package com.ei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public ModelAndView home() {

        ModelAndView mav = new ModelAndView("home");
        return mav;

    }

    @RequestMapping(value = "/alertsManage")
    public ModelAndView alertsmanage() {

        ModelAndView mav = new ModelAndView("alertsManage");
        return mav;

    }

    @RequestMapping(value = "/announcementsManage")
    public ModelAndView announcementsmanage() {

        ModelAndView mav = new ModelAndView("announcementsManage");
        return mav;

    }

}
