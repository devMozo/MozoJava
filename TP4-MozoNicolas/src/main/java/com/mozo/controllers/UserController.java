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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private iUserDAO tUserDAO;

    @Autowired
    private iNavigatorDAO tNavigatorDAO;

    @Autowired
    private iOSDAO tOSDAO;

    @RequestMapping(value = "/")
    @Transactional
    public Iterable<User> getIP(){
        // Get a Request object from the request sent
        HttpServletRequest tRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        // Get the IP from the object
        String strIp = tRequest.getRemoteAddr();
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
        tUser.setIp(strIp);
        // Try too save the user
        try {
            // Save the name of the browser
            String strNavigatorName = tBrowser.getName() + " " + tBrowserVersion.getMajorVersion();
            // Check if the browser exists inside the DB
            // And if exists put the browser inside of its respective model
            Navigator tNavigator = tNavigatorDAO.findOneByName(strNavigatorName);
            // If the browser doesn't exist
            if(tNavigator == null){
                // Initialize the Navigator's model
                tNavigator = new Navigator();
                // Set the name of the browser inside the object
                tNavigator.setName(strNavigatorName);
                // Save the Browser in the DB
                this.tNavigatorDAO.save(tNavigator);
            }
            // Save the name of the OS
            String strOSName = tOperatingSystem.getName();
            // Check if the browser exists inside the DB
            // Create a new OS's model
            OS tOS = tOSDAO.findOneByName(strOSName);
            // If the browser doesn't exist
            if(tOS == null) {
                // Initialize the OS's model
                tOS = new OS();
                // Save the operative system's name
                tOS.setName(strOSName);
                // Save the OS
                this.tOSDAO.save(tOS);
            }
            // Save the id of the OS
            tUser.setOs(tOS);
            // Save the id of the browser
            tUser.setBrowser(tNavigator);
            // If the user doesn't exist on the DB
            if(this.tUserDAO.findOneByIp(strIp) == null) {
                // Save this User on the DB
                this.tUserDAO.save(tUser);
            } else {
                // Update the user
                this.tUserDAO.updateUser(strIp, tNavigator, tOS);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        // Return this IP
        return this.tUserDAO.findAll();
    }

    @PostMapping(value = "/action/getBrowserMostUsed")
    public List<Map<String, Object>> getBrowserMostUsed(){
        // Return this IP
        return this.tUserDAO.getBrowserMostUsed();
    }

    @PostMapping(value = "/action/getOSMostUsed")
    public List<Map<String, Object>> getOSMostUsed(){
        // Return this IP
        return this.tUserDAO.getOSMostUsed();
    }

    @PostMapping(value = "/action/getCombinationMostUsed")
    public List<Map<String, Object>> getCombinationMostUsed(){
        // Return this IP
        return this.tUserDAO.getCombinationMostUsed();
    }
}
