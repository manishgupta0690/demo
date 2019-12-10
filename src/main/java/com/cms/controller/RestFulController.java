package com.cms.controller;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.model.user.User;
import com.cms.model.user.UserLoginProfile;
import com.cms.service.user.UserService;
import com.cms.utils.StringUtilityClass;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class RestFulController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/save_user_from_other_source", method = RequestMethod.POST)
    public String saveUserFromOtherSource(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String jsonDataStr = "";
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            // //logger.error("JSON Data:" + (jb != null ? jb.toString() :
            // "Empty"));
        } catch (Exception e) {

        }

        jsonDataStr = (jb != null ? StringUtilityClass.isNotNullAndNotEmpty(jb.toString()) ? jb.toString() : StringUtilityClass
                .isNotNullAndNotEmpty(request.getParameter("requestData")) ? request.getParameter("requestData") : "Empty" : "Empty");

        // JSONObject
        JSONArray array = new JSONArray(jsonDataStr);

        String firstName = "";
        String lastName = "";
        int age = 0;
        String userName = "";
        String password = "";
        User user = new User();
        UserLoginProfile ul = new UserLoginProfile();
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            if (jsonObj.has("first_name")) {
                firstName = jsonObj.getString("first_name");
            }

            if (jsonObj.has("last_name")) {
                lastName = jsonObj.getString("last_name");
            }

            if (jsonObj.has("age")) {
                age = jsonObj.getInt("age");
            }
            if (jsonObj.has("user_name")) {
                password = jsonObj.getString("user_name");
            }

            if (jsonObj.has("password")) {
                password = jsonObj.getString("password");
            }

            String dataStr = jsonObj.getString("extra_data");
            JSONArray otherData = new JSONArray(dataStr);
            for (int j = 0; j < otherData.length(); j++) {
                JSONObject jsonObjTemp = otherData.getJSONObject(j);
                if (jsonObjTemp.has("name")) {
                    String name = jsonObjTemp.getString("name");
                }

                if (jsonObjTemp.has("email")) {
                    String email = jsonObjTemp.getString("email");
                }
            }
        }

        user.setFirstName(firstName);
        user.setLastName(lastName);
        // user.setAge(age);
        user.setUserLoginProfile(ul);
        ul.setUserName(userName);
        ul.setPassword(password);
        ul.setUser(user);

        boolean result = userService.saveUser(user);
        String returnResponseStr = "";
        if (result) {
            returnResponseStr = "success";
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        // response.setContentType("txt");
        try {
            response.setContentLength(returnResponseStr.length());
            response.getWriter().write(returnResponseStr);
        } catch (Exception e) {
        }

        // JSONArray jsonArray = null;
        return "success";
    }
    
    
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String jsonDataStr = "";
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            // //logger.error("JSON Data:" + (jb != null ? jb.toString() :
            // "Empty"));
        } catch (Exception e) {

        }

        jsonDataStr = (jb != null ? StringUtilityClass.isNotNullAndNotEmpty(jb.toString()) ? jb.toString() : StringUtilityClass
                .isNotNullAndNotEmpty(request.getParameter("requestData")) ? request.getParameter("requestData") : "Empty" : "Empty");

        // JSONObject
        JSONArray array = new JSONArray(jsonDataStr);

        String firstName = "";
        String lastName = "";
        int age = 0;
        String userName = "";
        String password = "";
        User user = new User();
        UserLoginProfile ul = new UserLoginProfile();
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            if (jsonObj.has("log")) {
                JSONObject jobj = jsonObj.getJSONObject("log");
                System.out.println(jobj.toString());
                JSONArray pages = jobj.getJSONArray("pages");
                System.out.println(pages.toString());
                JSONArray entries = jobj.getJSONArray("entries");
                for (int j = 0; j < entries.length(); j++) {
                    JSONObject entriesObj = entries.getJSONObject(j);
                }
                System.out.println(entries.toString());
                JSONObject creator = jobj.getJSONObject("creator");
                System.out.println(creator.toString());
            }
            

         /*   String dataStr = jsonObj.getString("extra_data");
            JSONArray otherData = new JSONArray(dataStr);
            for (int j = 0; j < otherData.length(); j++) {
                JSONObject jsonObjTemp = otherData.getJSONObject(j);
               
            }*/
        }

        ;

        boolean result = userService.saveUser(user);
        String returnResponseStr = "";
        if (result) {
            returnResponseStr = "success";
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        // response.setContentType("txt");
        try {
            response.setContentLength(returnResponseStr.length());
            response.getWriter().write(returnResponseStr);
        } catch (Exception e) {
        }

        // JSONArray jsonArray = null;
        return "success";
    }

}
