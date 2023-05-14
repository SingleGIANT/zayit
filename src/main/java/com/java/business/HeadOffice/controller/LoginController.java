package com.java.business.HeadOffice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.business.HeadOffice.entity.LoginRequest;

@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController {

    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;


    
    
    
    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

    System.out.println("username from properties file: " + username);

    System.out.println("password from properties file: " + password);

    System.out.println("username from login request: " + loginRequest.getUsername());

    System.out.println("password from login request: " + loginRequest.getPassword());

    if (loginRequest.getUsername().equals(username) && loginRequest.getPassword().equals(password)) {

    Map<String, Object> responseData = new HashMap<String, Object>();

    responseData.put("token", "2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys");

    responseData.put("username", username);

    return ResponseEntity.ok(responseData);

    } else {
    	 Map<String, Object> responseData = new HashMap<String, Object>();
    	 responseData.put("message", "username and password is incorrect");
    	 responseData.put("token", "");
//    	 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("message");
    	 return ResponseEntity.ok(responseData);

    }

    }
}
