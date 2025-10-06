package com.example.hotelmanagementsystem.dto.request;

public class HotelRequest {

    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private String hotelRating;

    public HotelRequest(String hotelName, String hotelAddress, String hotelPhone, String hotelEmail, String hotelRating) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelEmail = hotelEmail;
        this.hotelRating = hotelRating;
    }

    public HotelRequest() {
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
