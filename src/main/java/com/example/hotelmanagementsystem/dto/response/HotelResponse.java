package com.example.hotelmanagementsystem.dto.response;

import com.example.hotelmanagementsystem.entity.Hotel;

public class HotelResponse {

    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private String hotelRating;

    public HotelResponse(Long hotelId, String hotelName, String hotelAddress, String hotelPhone, String hotelEmail, String hotelRating) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelEmail = hotelEmail;
        this.hotelRating = hotelRating;
    }

    public HotelResponse() {
    }
    public HotelResponse(Hotel hotel){
        this.hotelId = hotel.getId();
        this.hotelName = hotel.getHotelName();
        this.hotelAddress = hotel.getHotelAddress();
        this.hotelPhone = hotel.getHotelPhone();
        this.hotelEmail = hotel.getHotelAddress();
        this.hotelRating =hotel.getRating();

    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
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

    public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }
}
