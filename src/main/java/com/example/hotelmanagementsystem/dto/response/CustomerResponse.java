package com.example.hotelmanagementsystem.dto.response;

import com.example.hotelmanagementsystem.entity.Customer;

public class CustomerResponse {

    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;

    public CustomerResponse(Long customerId, String customerName, String customerAddress, String customerEmail, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public CustomerResponse(Customer customer){
        this.customerId = customer.getId();
        this.customerName = customer.getCustomerName();
        this.customerAddress = customer.getCustomerAddress();
        this.customerEmail = customer.getCustomerEmail();
        this.customerPhone = customer.getCustomerPhone();

    }

    public CustomerResponse() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
