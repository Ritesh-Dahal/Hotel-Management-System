package com.example.hotelmanagementsystem.dto.request;

import java.time.LocalDate;

public class PaymentRequest {

    private Long bookingId;
    private LocalDate paymentDate;
    private Float paymentAmount;
    private String paymentMethod;
    private String paymentStatus;

    public PaymentRequest(LocalDate paymentDate, Long bookingId, Float paymentAmount, String paymentMethod, String paymentStatus) {
        this.paymentDate = paymentDate;
        this.bookingId = bookingId;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public PaymentRequest() {
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
