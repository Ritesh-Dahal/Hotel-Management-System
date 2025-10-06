package com.example.hotelmanagementsystem.entity;

import com.example.hotelmanagementsystem.dto.request.BookingRequest;
import com.example.hotelmanagementsystem.enums.Status;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate bookingDate;
    @Enumerated(EnumType.STRING)
    private Status bookingStatus;



    @ManyToOne
    private  Customer customer;


    @OneToOne
    private Room singleRoom;





    @OneToOne(mappedBy = "booking")
    private Payment payment;


    public Booking(Long id, LocalDate checkInDate, LocalDate checkOutDate, LocalDate bookingDate, String bookingStatus) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingDate = bookingDate;
        this.bookingStatus = Status.valueOf(bookingStatus);

    }

    public Booking() {
    }

    public Booking(BookingRequest bookingRequest){
        this.checkInDate = bookingRequest.getCheckInDate();
        this.checkOutDate = bookingRequest.getCheckOutDate();
        this.bookingDate = bookingRequest.getBookingDate();
        this.bookingStatus = Status.valueOf(bookingRequest.getBookingStatus());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Status getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Status bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Room getSingleRoom() {
        return singleRoom;
    }

    public void setSingleRoom(Room singleRoom) {
        this.singleRoom = singleRoom;
    }
}
