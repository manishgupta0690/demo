package com.cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.model.user.User;
import com.cms.model.user.UserLoginProfile;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MethodType;

@RestController
public class WebController {
    
    @RequestMapping(value ="/test-link",method = RequestMethod.GET, produces = "application/json")
    public User getUser(){
        
        User user = new User();
        user.setFirstName("manish");
        user.setEmail("manishkr.bce@gmail.com");
        return user;
        
    }
    
    
    @RequestMapping(value ="/get-user-list",method = RequestMethod.GET, produces = "application/json")
    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setFirstName("manish");
        UserLoginProfile ul = new UserLoginProfile();
        ul.setId(100);
        ul.setUserName("manu");
        user.setUserLoginProfile(ul);
        user.setEmail("manishkr.bce@gmail.com");
        
        User user1 = new User();
        user1.setFirstName("manish");
        user1.setEmail("manishkr.bce@gmail.com");
        user1.setUserLoginProfile(ul);
        userList.add(user);
        userList.add(user1);
        return userList;
        
    }
    
    @RequestMapping(value ="/save-user-test",method = RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        System.out.println("Hello");
    }

}
