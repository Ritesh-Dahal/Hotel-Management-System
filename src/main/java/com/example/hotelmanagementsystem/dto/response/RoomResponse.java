package com.example.hotelmanagementsystem.dto.response;

import com.example.hotelmanagementsystem.entity.Room;
import com.example.hotelmanagementsystem.enums.RoomType;
import com.example.hotelmanagementsystem.enums.Status;

public class RoomResponse {

    private Long roomId;
    private Long hotelId;
    private Integer roomNumber;
    private RoomType roomType;
    private Float perNightPrice;
    private Status roomStatus;

    public RoomResponse(Long roomId, Long hotelId, Integer roomNumber, String roomType, Float perNightPrice, String roomStatus) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.roomType = RoomType.valueOf(roomType);
        this.perNightPrice = perNightPrice;
        this.roomStatus = Status.valueOf(roomStatus);
    }

    public RoomResponse() {
    }

    public RoomResponse( Room room) {
        this.roomId = room.getId();
        this.hotelId = room.getHotel().getId();
        this.roomNumber = Integer.parseInt(room.getRoomNumber());
        this.roomType = room.getRoomType();
        this.perNightPrice = room.getPricePerNight();
        this.roomStatus = room.getRoomStatus();
    }





    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Float getPerNightPrice() {
        return perNightPrice;
    }

    public void setPerNightPrice(Float perNightPrice) {
        this.perNightPrice = perNightPrice;
    }

    public Status getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Status roomStatus) {
        this.roomStatus = roomStatus;
    }
}
