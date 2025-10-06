package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.dto.request.RoomRequest;
import com.example.hotelmanagementsystem.dto.response.RoomResponse;
import com.example.hotelmanagementsystem.entity.Hotel;
import com.example.hotelmanagementsystem.entity.Room;
import com.example.hotelmanagementsystem.exception.AlreadyExistException;
import com.example.hotelmanagementsystem.exception.NotFoundException;
import com.example.hotelmanagementsystem.repository.HotelRepo;
import com.example.hotelmanagementsystem.repository.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private RoomRepo roomRepo;
    private HotelRepo hotelRepo;

    public RoomService(RoomRepo roomRepo,HotelRepo hotelRepo){
        this.roomRepo = roomRepo;
        this.hotelRepo= hotelRepo;
    }


    public void addSingleRoom(RoomRequest request){
       Hotel hotel= hotelRepo.findById(request.getHotelId())
                .orElseThrow(()-> new NotFoundException("Hotel Doesn't Exit"));

        Optional<Room> optionalRoom = roomRepo.findByHotelAndRoomNumberAndIsDeletedFalse(hotel,request.getRoomNumber().toString());

        if(optionalRoom.isPresent()){
            throw new AlreadyExistException("Hotel with the room number "+ request.getRoomNumber()+" already exist");
        }

        Room room = new Room(request);
        room.setHotel(hotel);
        roomRepo.save(room);


    }

    public RoomResponse getSingleRoomByRoomId(Long id){

        Optional<Room> optionalRoom =roomRepo.findById(id);
        RoomResponse roomResponse;
        if(optionalRoom.isPresent()){
            roomResponse = new RoomResponse(optionalRoom.get());

        }else {
            throw  new NotFoundException("Room not Found");
        }
        return roomResponse;

    }

    public List<RoomResponse> getRoomByHotelId(Long id){

           Hotel hotel = hotelRepo.findById(id).orElseThrow(()-> new NotFoundException("Hotel Doesn't exist"));



        List<Room> roomList = roomRepo.findByHotel(hotel);
        List<RoomResponse> responseList;
        if(roomList.isEmpty()){
            throw new NotFoundException("Room not Found");
        }else{
          responseList=roomList.stream().map(RoomResponse::new).toList();
        }
        return responseList;

    }

    public List<RoomResponse> getRoomByHotelName(String name){

          Hotel hotel = hotelRepo.findHotelByHotelNameAndIsDeletedFalse(name).
                  orElseThrow(() -> new NotFoundException("Hotel Not Found"));

        List<Room> roomList = roomRepo.findByHotel(hotel);
        List<RoomResponse> responseList;
        if(roomList.isEmpty()){
            throw new NotFoundException("Room not Found");
        }else{
            responseList=roomList.stream().map(RoomResponse::new).toList();
        }
        return responseList;

    }





//
//    public void addListOfRooms(List<RoomRequest> roomRequestList){
//
//        roomRequestList.stream().
//                forEach(RoomRequest -> hotelRepo.findById(RoomRequest.getHotelId())
//                        .orElseThrow(()->new AlreadyExistException("Hotel Doesn't Exist")));
//
//
//        List<Room> roomList = roomRequestList.stream().map(Room::new).toList();
//
//        roomRepo.saveAll(roomList);
//
//    }








    public void addListOfRoomForHotel(Long id,List<RoomRequest> roomRequestList){

                Hotel hotel = hotelRepo.findById(id).orElseThrow(()-> new NotFoundException("Hotel Doesn't Exist"));


            for(RoomRequest request : roomRequestList){

               Optional<Room> room = roomRepo.findByHotelAndRoomNumberAndIsDeletedFalse(hotel,request.getRoomNumber().toString());

                        if(room.isPresent()){
                            throw new AlreadyExistException("Hotel with the room number "+ request.getRoomNumber()+" already exist");
                        }

            }


                List<Room> roomList = new ArrayList<>();
                for(RoomRequest roomRequest : roomRequestList){

                    Room room= new Room(roomRequest);
                    room.setHotel(hotel);
                    roomList.add(room);

                }
                roomRepo.saveAll(roomList);


    }

    public void deleteRoomById(Long id){

        Room room = roomRepo.findById(id).orElseThrow(()-> new NotFoundException("Hotel Not Found"));

        room.setDeleted(true);
        roomRepo.save(room);

    }








}
