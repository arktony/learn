package com.enclave.learn.controllers;

import com.enclave.learn.domain.User;
import com.enclave.learn.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();

        if (tempEmail !=null && !"".equals(tempEmail)){
           User dbUser = registrationService.fetchUserByEmailId(tempEmail);
           if (dbUser != null){
               throw new Exception("User with " +tempEmail+ " already exists");
           }
        }

        User userObject =null;
        userObject = registrationService.saveUser(user);
        return userObject;
    }
}
