package com.example.hotelmanagementsystem.dto.request;

public class RoomRequest {

    private Long hotelId;
    private Integer roomNumber;
    private String roomType;
    private Float perNightPrice;
    private String roomStatus;

    public RoomRequest(Long hotelId, Integer roomNumber, String roomType, Float perNightPrice, String roomStatus) {
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.perNightPrice = perNightPrice;
        this.roomStatus = roomStatus;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getPerNightPrice() {
        return perNightPrice;
    }

    public void setPerNightPrice(Float perNightPrice) {
        this.perNightPrice = perNightPrice;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
