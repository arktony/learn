package com.enclave.learn.controllers;

import com.enclave.learn.domain.User;
import com.enclave.learn.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:8081")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();

        if (tempEmail !=null && !"".equals(tempEmail)){
           User dbUser = registrationService.fetchUserByEmail(tempEmail);
           if (dbUser != null){
               throw new Exception("User with " +tempEmail+ " already exists");
           }
        }

        User userObject =null;
        userObject = registrationService.saveUser(user);
        return userObject;
    }

    @PostMapping("/handshake")
    @CrossOrigin(origins = "http://localhost:8081")
    public User handshakeHandler(@RequestBody User user) throws Exception {
        String dbMail = user.getEmail();
        String dbPassword = user.getPassword();

        User userObj =null;

        if (dbMail != null && dbPassword !=null){
            userObj = registrationService.fetchUserByEmailAndPassword(dbMail,dbPassword);
        }
        if (userObj == null){
            throw new Exception("User doesn't Exist");
        }
        return userObj;
    }
}
