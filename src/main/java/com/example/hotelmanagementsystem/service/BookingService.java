package com.example.hotelmanagementsystem.service;


import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.Customer;
import com.example.hotelmanagementsystem.entity.Room;
import com.example.hotelmanagementsystem.enums.Status;
import com.example.hotelmanagementsystem.exception.AlreadyBookedException;
import com.example.hotelmanagementsystem.exception.NotFoundException;
import com.example.hotelmanagementsystem.repository.BookingRepo;
import com.example.hotelmanagementsystem.repository.CustomerRepo;
import com.example.hotelmanagementsystem.repository.HotelRepo;
import com.example.hotelmanagementsystem.repository.RoomRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookingService {

    private BookingRepo bookingRepo;
    private CustomerRepo customerRepo;
    private HotelRepo hotelRepo;
    private RoomRepo roomRepo;

    public BookingService(BookingRepo bookingRepo, CustomerRepo customerRepo, HotelRepo hotelRepo, RoomRepo roomRepo) {
        this.bookingRepo = bookingRepo;
        this.customerRepo = customerRepo;
        this.hotelRepo = hotelRepo;
        this.roomRepo = roomRepo;
    }


    public void SingleBooking(Long customerId, long roomId,LocalDate checkOutDate){

        Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new NotFoundException("Customer with provided id not found"));
        Room room = roomRepo.findById(roomId).orElseThrow(() -> new NotFoundException("Room with provided id not found"));

        if(room.getRoomStatus().equals(Status.BOOKED)|| room.getDeleted()){

            throw  new AlreadyBookedException("Room Not Available");
        }

        Booking booking = new Booking();
        booking.setBookingStatus(Status.BOOKED);
        booking.setBookingDate(LocalDate.now());
        booking.setSingleRoom(room);
        booking.setCustomer(customer);
        booking.setCheckInDate(LocalDate.now());
        booking.setCheckOutDate(checkOutDate);

        room.setRoomStatus(Status.BOOKED);
        bookingRepo.save(booking);


    }






    public void bookByCustomerIdAndRoomId(Long customerId, List<Long> roomId,LocalDate checkOutDate){

          Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new NotFoundException("Customer with provided id not found"));

            List<Room> roomList = new ArrayList<>();

          for(Long id : roomId) {
              Room room = roomRepo.findById(id).orElseThrow(() -> new NotFoundException("Room with provided id not found"));

              if(room.getRoomStatus().equals(Status.BOOKED)){
                  throw new AlreadyBookedException("Room with room number "+ room.getId() +" already booked");
              }

              room.setRoomStatus(Status.BOOKED);
              roomList.add(room);
          }


            Booking booking = new Booking();
            booking.setBookingDate(LocalDate.now());
            booking.setCustomer(customer);
            booking.setBookingStatus(Status.BOOKED);
            booking.setCheckInDate(LocalDate.now());
            booking.setCheckOutDate(checkOutDate);

            bookingRepo.save(booking);


    }


    public void cancelBooking(Long id){

        Booking booking = bookingRepo.findById(id).orElseThrow(()-> new NotFoundException("Booking with booking id "+ id+" not found"));



        Room room = booking.getSingleRoom();

        if(room!=null) {
            room.setRoomStatus(Status.AVAILABLE);
            room.setBooking(null);
            roomRepo.saveAndFlush(room);
        }
        bookingRepo.deleteById(id);

    }










}
