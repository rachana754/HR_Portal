package com.ei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ei.form.LoginForm;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login", "/"})
    public ModelAndView login(@ModelAttribute("loginFm") LoginForm lForm) {

        ModelAndView mav = new ModelAndView("login");
        lForm.setUsername("Pennywise");
        lForm.setPassword("ball00n5");
        return mav;
    }
}
