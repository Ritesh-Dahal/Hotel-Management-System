package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.dto.request.BookingRequest;
import com.example.hotelmanagementsystem.service.BookingService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService= bookingService;

    }


//    @PostMapping("/bookRoomByCustomerId/{id}")
//
//    public ResponseEntity<?> bookByCustomerIdAndRoomId(@PathVariable Long customerId, @RequestBody List<Long> roomId, @RequestBody LocalDate checkOutDate){
//
//        bookingService.bookByCustomerIdAndRoomId(customerId,roomId,checkOutDate);
//            return  null;
//    }


    @PostMapping("/booking/{customerId}")
    public ResponseEntity<?> bookByCustomerIdAndRoomID(@PathVariable Long customerId, @RequestParam Long roomId ,@RequestParam LocalDate checkOutDate){

        bookingService.SingleBooking(customerId,roomId,checkOutDate);

        return BaseController.successResponse("Room Sucessfully Booked","{}");


    }

    @DeleteMapping("/booking/cancel/{id}")

    public ResponseEntity<?> cancelBooking(@PathVariable Long id){

        bookingService.cancelBooking(id);

        return BaseController.successResponse("Booking Canceled Sucessfully ","{}");


    }


}
