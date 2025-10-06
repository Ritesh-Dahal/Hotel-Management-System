package com.example.hotelmanagementsystem.dto.response;

import java.time.LocalDate;

public class PaymentResponse {

    private Long paymentId;
    private Long bookingId;
    private LocalDate paymentDate;
    private Float paymentAmount;
    private String paymentMethod;
    private String paymentStatus;

    public PaymentResponse(Long paymentId, Long bookingId, LocalDate paymentDate, Float paymentAmount, String paymentMethod, String paymentStatus) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public PaymentResponse() {
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

