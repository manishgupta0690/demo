package com.cms.utils;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;


import com.cms.model.user.User;
import com.cms.model.user.UserLoginProfile;
public class ServiceObject {
    
    public static User getUserObj(HttpServletRequest request){
        User user = new User();
        String firstName = UtilityService.isNotNullNotEmpty(request.getParameter("first_name")) ? request.getParameter("first_name"):"";
        String lastName = UtilityService.isNotNullNotEmpty(request.getParameter("last_name")) ? request.getParameter("last_name"):"";
        int age = UtilityService.isNotNullNotEmpty(request.getParameter("age")) ?Integer.valueOf(request.getParameter("age")) :0;
        String email = UtilityService.isNotNullNotEmpty(request.getParameter("email")) ? request.getParameter("email"):"";
        String phone = UtilityService.isNotNullNotEmpty(request.getParameter("phone")) ? request.getParameter("phone"):"";
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setMobileNo(phone);
        return user;
    }
    
    public static UserLoginProfile getUserLoginProfileObj(HttpServletRequest request){
        UserLoginProfile UL = new UserLoginProfile();
        String user_name = UtilityService.isNotNullNotEmpty(request.getParameter("user_name")) ? request.getParameter("user_name"):"";
        String password = UtilityService.isNotNullNotEmpty(request.getParameter("password")) ? request.getParameter("password"):"";
        Calendar cl = Calendar.getInstance();
       
        UL.setUserName(user_name);
        UL.setPassword(password);
        UL.setCreateDate(DateTimeUtils.calenderToTimestamp(cl));
        UL.setLastModificationDate(DateTimeUtils.calenderToTimestamp(cl));
        return UL;
    }

}
