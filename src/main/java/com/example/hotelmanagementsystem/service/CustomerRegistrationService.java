package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.dto.request.CustomerRegistrationRequest;
import com.example.hotelmanagementsystem.entity.CustomerRegistration;
import com.example.hotelmanagementsystem.exception.AlreadyExistException;
import com.example.hotelmanagementsystem.repository.CustomerRegisterRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerRegistrationService {

    private CustomerRegisterRepo customerRegisterRepo;

    public CustomerRegistrationService(CustomerRegisterRepo customerRegisterRepo){

        this.customerRegisterRepo = customerRegisterRepo;
    }



    public void customerRegistration(CustomerRegistrationRequest registrationRequest){

        customerRegisterRepo.findByEmailAndIsDeletedFalse(registrationRequest.getEmail()).ifPresent(customerRegistration ->  new AlreadyExistException("User with email: "+ registrationRequest.getEmail()+" already exist"));

        CustomerRegistration registration = new CustomerRegistration(registrationRequest);
        customerRegisterRepo.save(registration);

    }
}
