package com.example.hotelmanagementsystem.entity;

import com.example.hotelmanagementsystem.dto.request.CustomerRequest;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "customer")
    private List<Booking> booking = new ArrayList<>();

    public Customer(Long id, String customerName, String customerAddress, String customerPhone, String customerEmail) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
    }

    public Customer (CustomerRequest customerRequest){
        this.customerName = customerRequest.getCustomerName();
        this.customerAddress = customerRequest.getCustomerAddress();
        this.customerPhone = customerRequest.getCustomerPhone();
        this.customerEmail = customerRequest.getCustomerEmail();
    }



    public Customer() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
