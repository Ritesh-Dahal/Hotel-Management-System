package com.example.hotelmanagementsystem.entity;

import com.example.hotelmanagementsystem.dto.request.RoomRequest;
import com.example.hotelmanagementsystem.enums.RoomType;
import com.example.hotelmanagementsystem.enums.Status;
import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private Float pricePerNight;
    @Enumerated(EnumType.STRING)
    private Status roomStatus;
    private Boolean isDeleted = false;

    @ManyToOne()
    private Hotel hotel;

    @OneToOne(mappedBy = "singleRoom")
    private Booking booking;


    public Room(Long id, String roomNumber, RoomType roomType, Float pricePerNight, Status roomStatus, Hotel hotel, Booking booking) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.roomStatus = roomStatus;
        this.hotel = hotel;
        this.booking = booking;
    }

    public Room() {
    }

    public Room(RoomRequest roomRequest){
        this.roomNumber = roomRequest.getRoomNumber().toString();
        this.roomType = RoomType.valueOf(roomRequest.getRoomType());
        this.pricePerNight = roomRequest.getPerNightPrice();
        this.roomStatus = Status.valueOf(roomRequest.getRoomStatus());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Float getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Status getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Status roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
