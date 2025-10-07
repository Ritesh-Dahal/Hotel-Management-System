package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.dto.request.CustomerRegistrationRequest;
import com.example.hotelmanagementsystem.service.CustomerRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {


    public  CustomerRegistrationService registrationService;

    RegistrationController(CustomerRegistrationService registrationService){
        this.registrationService= registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRegistrationRequest registrationRequest){

        registrationService.customerRegistration(registrationRequest);
        return BaseController.successResponse("User Register Successfully","{}");

    }
}
