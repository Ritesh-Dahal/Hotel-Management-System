package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.dto.request.CustomerRequest;
import com.example.hotelmanagementsystem.dto.response.CustomerResponse;
import com.example.hotelmanagementsystem.entity.Customer;
import com.example.hotelmanagementsystem.exception.NotFoundException;
import com.example.hotelmanagementsystem.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public void addCustomer(CustomerRequest customerRequest){

        Customer customer = new Customer(customerRequest);

        customerRepo.save(customer);

    }

    public CustomerResponse getCustomerById(Long id){

        Optional<Customer> optionalCustomer = customerRepo.findById(id);
        CustomerResponse customerResponse;
        if(optionalCustomer.isPresent()){
            customerResponse = new CustomerResponse(optionalCustomer.get());
         }else {
             throw  new NotFoundException("Customer Not Found");
         }

        return customerResponse;
    }

    public void deleteCustomerById(Long id){

        customerRepo.findById(id).orElseThrow(()-> new NotFoundException("Customer Not Found"));
        customerRepo.deleteById(id);

    }



}
