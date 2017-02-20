package com.brokeneye.a_001;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a007 on 2017. 2. 13..
 */

public class RegisterRequest extends StringRequest{

    final static private String URL = "http://broken-glasses.com/Register.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName,
                           String userBirth_year, String userBirth_month, String userBirth_day,
                           Response.Listener<String> listener){

//        userName = URLEncoder.encode(userName,"UTF-8");

        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("userBirth_year", userBirth_year);
        parameters.put("userBirth_month", userBirth_month);
        parameters.put("userBirth_day", userBirth_day);
    }

    @Override
    public Map<String, String> getParams(){

        return parameters;

    }

}
