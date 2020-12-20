package com.enclave.learn.repository;

import com.enclave.learn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
