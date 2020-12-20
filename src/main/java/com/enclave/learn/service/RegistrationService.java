package com.enclave.learn.service;

import com.enclave.learn.domain.User;
import com.enclave.learn.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepo registrationRepo;

    public User saveUser(User user){
        return registrationRepo.save(user);
    }

    public User fetchUserByEmail(String email){
       return registrationRepo.findByEmail(email);
    }

    public User fetchUserByEmailAndPassword(String email, String password){
        return registrationRepo.findByEmailAndPassword(email,password);
    }
}
