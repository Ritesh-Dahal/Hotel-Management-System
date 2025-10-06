package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.dto.request.CustomerRequest;
import com.example.hotelmanagementsystem.dto.response.CustomerResponse;
import com.example.hotelmanagementsystem.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service){

        this.service = service;

    }

    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest request){
            service.addCustomer(request);
        return BaseController.successResponse("Customer Added Successfully", "{ }");
    }

    @GetMapping("/customer/{id}")

    public ResponseEntity<?> getCustomerById(@PathVariable Long id){

        CustomerResponse response = service.getCustomerById(id);

        return BaseController.successResponse("Customer Found Successfully",response);

    }

    @DeleteMapping("/delete/customer/{id}")

    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id){

        service.deleteCustomerById(id);

        return BaseController.successResponse("Customer Deleted Successfully","{ }");

    }




}
