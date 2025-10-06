package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.entity.Hotel;
import com.example.hotelmanagementsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {

    List<Room> findByHotel(Hotel hotel);
     Optional<Room> findByHotelAndRoomNumberAndIsDeletedFalse(Hotel hotel, String roomNumber);

}
