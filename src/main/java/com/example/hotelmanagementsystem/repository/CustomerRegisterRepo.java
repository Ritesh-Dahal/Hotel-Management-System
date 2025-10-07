package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRegisterRepo extends JpaRepository<CustomerRegistration,Long> {

    Optional<CustomerRegistration> findByEmailAndIsDeletedFalse(String email);
}
