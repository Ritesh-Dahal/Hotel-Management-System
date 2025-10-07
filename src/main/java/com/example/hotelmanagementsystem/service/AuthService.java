package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.entity.CustomerRegistration;
import com.example.hotelmanagementsystem.exception.InvalidException;
import com.example.hotelmanagementsystem.repository.CustomerRegisterRepo;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthService {

    private CustomerRegisterRepo customerRegisterRepo;

    public AuthService(CustomerRegisterRepo customerRegisterRepo){
        this.customerRegisterRepo = customerRegisterRepo;

    }

    public CustomerRegistration ValidatingCustomer(String authorization){


        String encodedValue = authorization.substring(6); // removing Base form the field (Base afk0989hkj)
       byte[] byteArray = Base64.getDecoder().decode(encodedValue); // decoding the only needed value i.e username and password
        String userData = new String(byteArray); // converting byte into string which is in the form username:password
        String[] emailPassword = userData.split(":",2);


        String email = emailPassword[0];
        String password = emailPassword[1];

        if (email.isEmpty() || password.isEmpty()) {
            throw new InvalidException("Authorization header cannot be empty");
        }

        CustomerRegistration customer = customerRegisterRepo.findByEmailAndIsDeletedFalse(email).orElseThrow(()-> new InvalidException("Username or Password Invalid"));

        if (customer.getPassword().equals(password)){
            return customer;
        }else {

            throw  new InvalidException("Username or Password Invalid");
        }

    }

}
