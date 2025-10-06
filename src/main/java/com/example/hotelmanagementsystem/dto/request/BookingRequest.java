package com.example.hotelmanagementsystem.dto.request;

import java.time.LocalDate;

public class BookingRequest {

    private Long customerId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate bookingDate;
    private String bookingStatus;

    public BookingRequest(Long customerId, Long roomId, LocalDate checkInDate, LocalDate checkOutDate, LocalDate bookingDate, String bookingStatus) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
    }

    public BookingRequest() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
