package com.example.hotelmanagementsystem.entity;

import com.example.hotelmanagementsystem.dto.request.HotelRequest;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;
    private String hotelAddress;
    @Column(unique = true,length = 10)
    private String hotelPhone;
    @Column(unique = true)
    private String hotelEmail;
    private String rating;
    private Boolean isDeleted = false;



    @OneToMany(mappedBy = "hotel")
    private List<Room> room = new ArrayList<>();




    public Hotel(Long id, String hotelName, String hotelAddress, String hotelPhone, String hotelEmail, String rating) {
        this.id = id;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelEmail = hotelEmail;
        this.rating = rating;

    }

    public Hotel() {
    }

    public Hotel(HotelRequest hotelRequest){
        this.hotelName = hotelRequest.getHotelName();
        this.hotelAddress = hotelRequest.getHotelAddress();
        this.hotelPhone = hotelRequest.getHotelPhone();
        this.hotelEmail = hotelRequest.getHotelEmail();
        this.rating = hotelRequest.getHotelRating();

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }


}
