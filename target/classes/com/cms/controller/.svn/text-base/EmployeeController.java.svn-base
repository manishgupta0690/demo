package com.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @RequestMapping(value ="/")
    public ModelAndView defaultPage(HttpServletRequest request, HttpServletResponse response) {        
        ModelAndView model = new ModelAndView();
        model.setViewName("/employee/home");
        return model;
    }
    
    @RequestMapping(value ="home")
    public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) {        
        ModelAndView model = new ModelAndView();
        model.setViewName("/employee/home");
        return model;
    }
    
    @RequestMapping(value ="*")
    public ModelAndView defaultPageRedirect(HttpServletRequest request, HttpServletResponse response) {        
        return new ModelAndView("redirect:/employee/404");
    }
    
    @RequestMapping(value ="/404", method = RequestMethod.GET)
    public ModelAndView urlNotFound(HttpServletRequest request, HttpServletResponse response) {        
        ModelAndView model = new ModelAndView();
        model.setViewName("/employee/404");
        return model;
    }
}
