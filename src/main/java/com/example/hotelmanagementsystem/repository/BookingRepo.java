package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
