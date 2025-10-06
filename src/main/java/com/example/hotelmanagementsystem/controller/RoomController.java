package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.dto.request.RoomRequest;
import com.example.hotelmanagementsystem.dto.response.RoomResponse;
import com.example.hotelmanagementsystem.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }



    @PostMapping("/room")

    public ResponseEntity<?> addSingleRoom(@RequestBody RoomRequest roomRequest){

            roomService.addSingleRoom(roomRequest);

            return BaseController.successResponse("Room Added Successfully","{ }");


    }

    @PostMapping("/rooms/{id}")

    public ResponseEntity<?> addListOfRoom(@PathVariable Long id ,@RequestBody List<RoomRequest> roomRequestList){

        roomService.addListOfRoomForHotel(id,roomRequestList);
        return BaseController.successResponse("Rooms Added SuccessFully","{ }");
    }

    @GetMapping("/room/{id}")

    public ResponseEntity<?> getRoomById(@PathVariable Long id){

        RoomResponse roomResponse = roomService.getSingleRoomByRoomId(id);

        return BaseController.successResponse("Room Found Successfully",roomResponse);

    }

    @GetMapping("/hotel/room/{id}")

    public ResponseEntity<?> getRoomByHotelId(@PathVariable Long id){

        List<RoomResponse> roomResponseList = roomService.getRoomByHotelId(id);

        return BaseController.successResponse("Room Found Successfully",roomResponseList);

    }

    @GetMapping("/hotel/room")

    public ResponseEntity<?> getRoomByHotelName(@RequestParam String name){

        List<RoomResponse> roomResponseList = roomService.getRoomByHotelName(name);

        return BaseController.successResponse("Room Found Successfully",roomResponseList);

    }

    @DeleteMapping("/delete/room/{id}")

    public ResponseEntity<?> deleteRoomById(@PathVariable Long id){

            roomService.deleteRoomById(id);
        return BaseController.successResponse("Room Deleted Successfully","{ }");

    }





}