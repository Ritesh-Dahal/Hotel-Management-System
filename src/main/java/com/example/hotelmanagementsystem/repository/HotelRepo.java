package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findHotelByHotelNameAndIsDeletedFalse(String name);


}
