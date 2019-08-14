package com.ei.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ei.form.ForgotPasswordForm;
import com.ei.form.LoginForm;
import com.ei.service.ProfileService;

/**
 * Communicates with the Login page and handles sending information to and receiving information from the front end.
 * @author bstout
 */
@Controller
public class LoginController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private LoginControllerHelper loginControllerHelper;

    /**
     * Creates a Model and View of the login page with form attributes
     */
    @GetMapping(value = { "/login", "/" })
    public ModelAndView login(@ModelAttribute("loginForm") LoginForm lForm,
            @ModelAttribute("forgotPassword") ForgotPasswordForm passForm) {
        return new ModelAndView("login");
    }

    /**
     * Validates login text fields, remains on login page if fields are invalid displaying error messages or redirects
     * to home page if fields are valid
     */
    @PostMapping(value = { "/login" })
    public String submit(@ModelAttribute(value = "loginForm") @Valid LoginForm loginForm,
            BindingResult loginBindingResult,
            @ModelAttribute(value = "forgotPassword") @Valid ForgotPasswordForm forgotForm,
            BindingResult forgotBindingResult) throws Exception {
        // get all errors from loginForm
        List<ObjectError> errors = loginBindingResult.getAllErrors();
        // store invalid fields from loginControllerHelper
        List<String> invalidFields = new ArrayList<String>();

        // if loginForm is filled out correctly
        if (errors.isEmpty()) {
            // check for valid username and password and for each invalid field display error
            invalidFields = loginControllerHelper.validateUsernameAndPassword(loginForm.getUsername(),
                    loginForm.getPassword());
            for (String field : invalidFields) {
                loginBindingResult.rejectValue(field, "error.loginForm", "Sorry, we didn't recognize your " + field);
            }
        }
        // if there are no errors go to home page, else stay on login and display errors
        return errors.isEmpty() ? "redirect:home" : "login";
    }

    /**
     * Validates forgot password modal's username text field. If email is found by username, returns the email address
     * in a message on the login page. If not found returns an error message on the login page. Displays error message
     * within the modal if username is not valid. *
     */
    @PostMapping(value = { "/forgot" })
    public ModelAndView forgotPassword(@ModelAttribute(value = "forgotPassword") @Valid ForgotPasswordForm forgotForm,
            BindingResult forgotBindingResult, @ModelAttribute(value = "loginForm") @Valid LoginForm loginForm,
            BindingResult loginBindingResult) {
        // get the email by username
        String email = profileService.getEmailByUsername(forgotForm.getUsername2());
        ModelAndView mav = new ModelAndView("login");
        // if email is found, display email address with success message
        if (!StringUtils.isEmpty(email)) {
            mav.addObject("successEmailMessage", "\u2705 Email was sent to: " + email);
            return mav;
            // else display an error message
        } else {
            mav.addObject("errorEmailMessage", "\u274C Sorry, we didn't find your email. Please try again!");
            return mav;
        }
    }
}