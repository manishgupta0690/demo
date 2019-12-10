package com.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController { 
    
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ModelAndView defaultPageforAll(HttpServletRequest request, HttpServletResponse response) {        
        ModelAndView model = new ModelAndView();
        model.setViewName("index");        
        return model;
    }
    
    @RequestMapping(value ="404", method = RequestMethod.GET)
    public ModelAndView pageNotFound(HttpServletRequest request, HttpServletResponse response) {        
        ModelAndView model = new ModelAndView();
        model.setViewName("404");        
        return model;
    }
    
    @RequestMapping(value ="add-user-proccess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) { 
        
        ModelAndView model = new ModelAndView();
        model.setViewName("404");        
        return model;
    }
    
    @RequestMapping(value ="*")
    public ModelAndView defaultPageRedirect(HttpServletRequest request, HttpServletResponse response) {        
        ModelAndView model = new ModelAndView();
        model.setViewName("404");        
        return new ModelAndView("redirect:/404");
    }

}
