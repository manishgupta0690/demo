package com.cms.utils;

public class UtilityService {
    
    public static boolean isNotNullNotEmpty(String val){
        boolean response =false;
        if(val!=null && val.trim().length()>0){
            response = true;
        }
        return response;
    }

}
