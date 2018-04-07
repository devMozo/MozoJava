package com.mozo.controllers;

import com.mozo.daos.UserDAO;
import com.mozo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserDAO tUserDAO;

    @RequestMapping(value = "/")
    public String getIP(){
        // Get a Request object from the request sent
        HttpServletRequest tRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        // Get the IP from the object
        String ip = tRequest.getRemoteAddr();
        // Create a new User
        User tUser = new User();
        // Set the IP to the User
        tUser.setIp(ip);
        // Try too save the user
        try {
            // Save this User on the DB
            this.tUserDAO.insertUser(tUser);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        // Return this IP
        return ip;
    }
}
