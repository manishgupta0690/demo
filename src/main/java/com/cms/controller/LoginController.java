package com.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cms.model.user.User;
import com.cms.model.user.UserLoginProfile;
import com.cms.service.user.UserService;
import com.cms.utils.ServiceObject;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    
    private ServiceObject so;

    @RequestMapping(value = "/login")
    public ModelAndView defaultPage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/login");
        return model;
    }

    @RequestMapping(value = "/emp-login-process", method = RequestMethod.POST)
    public ModelAndView employeeLoginProcess(HttpServletRequest request, HttpServletResponse response) {
        boolean success = true;
        if (success) {
            return new ModelAndView("redirect:/employee/home");
        }
        return new ModelAndView("redirect:/login?error=");
    }

    @RequestMapping(value = "/registration-page", method = RequestMethod.GET)
    public ModelAndView getRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/registration");
        return model;
    }

    @RequestMapping(value = "/save-user", method = RequestMethod.POST)
    public ModelAndView saveUserInfo(HttpServletRequest request, HttpServletResponse response) {

        User userObj = ServiceObject.getUserObj(request);
        UserLoginProfile ul = ServiceObject.getUserLoginProfileObj(request);
        userObj.setUserLoginProfile(ul);
        userService.saveUser(userObj);
        ModelAndView model = new ModelAndView();
        model.addObject("USER_OBJ", userObj);
        model.setViewName("/employee/display_customer_details");
        return model;
    }

}
