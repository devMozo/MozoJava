package com.mozo.controllers;

import com.mozo.models.Navigator;
import com.mozo.models.OS;
import com.mozo.models.User;
import com.mozo.daos.iUserDAO;
import com.mozo.daos.iNavigatorDAO;
import com.mozo.daos.iOSDAO;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private iUserDAO tUserDAO;

    @Autowired
    private iNavigatorDAO tNavigatorDAO;

    @Autowired
    private iOSDAO tOSDAO;

    @RequestMapping(value = "/")
    public Iterable<User> getIP(){
        // Get a Request object from the request sent
        HttpServletRequest tRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        // Get the IP from the object
        String ip = tRequest.getRemoteAddr();
        // Get the User-Agent propertie from the Request
        UserAgent tUserAgent = UserAgent.parseUserAgentString(tRequest.getHeader("User-Agent"));
        // Get the OS (Operating System)
        OperatingSystem tOperatingSystem = tUserAgent.getOperatingSystem();
        // Get the browser object
        Browser tBrowser = tUserAgent.getBrowser();
        // Now the version..
        Version tBrowserVersion = tUserAgent.getBrowserVersion();
        // Create a new User
        User tUser = new User();
        // Set the IP to the User
        tUser.setIp(ip);
        // Try too save the user
        try {
            // Create a new navigator's model
            Navigator tNavigator = new Navigator();
            // Set the name of the browser inside the object
            tNavigator.setName(tBrowser.getName() + " " + tBrowserVersion.getMajorVersion());
            // Create a new OS's model
            OS tOS = new OS();
            // Save the operative system's name
            tOS.setName(tOperatingSystem.getName());
            // Save the Browser in the DB
            this.tNavigatorDAO.save(tNavigator);
            // Save the OS
            this.tOSDAO.save(tOS);
            // Save this User on the DB
            this.tUserDAO.save(tUser);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        // Return this IP
        return this.tUserDAO.findAll();
    }

   /* @RequestMapping(value = "/action/getBrowserMostUsed")
    public List<User> getBrowserMostUsed(){

        // Return this IP
        return this.tUserDAO.findAllUsers();
    }

    @RequestMapping(value = "/action/getOSMostUsed")
    public List<User> getOSMostUsed(){

        // Return this IP
        return this.tUserDAO.findAllUsers();
    }

    @RequestMapping(value = "/action/getCombinationMostUsed")
    public List<User> getCombinationMostUsed(){

        // Return this IP
        return this.tUserDAO.findAllUsers();
    }*/
}
