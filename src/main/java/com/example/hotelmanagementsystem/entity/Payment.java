package com.example.hotelmanagementsystem.entity;


import com.example.hotelmanagementsystem.dto.request.PaymentRequest;
import com.example.hotelmanagementsystem.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate paymentDate;
    private Float paymentAmount;
    private String paymentMethod;
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @OneToOne
    private Booking booking;

    public Payment(Long id, LocalDate paymentDate, Float paymentAmount, String paymentMethod, Status paymentStatus) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Payment(PaymentRequest paymentRequest){
        this.paymentDate = paymentRequest.getPaymentDate();
        this.paymentAmount = paymentRequest.getPaymentAmount();
        this.paymentMethod = paymentRequest.getPaymentMethod();
        this.paymentStatus = Status.valueOf(paymentRequest.getPaymentStatus());

    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
