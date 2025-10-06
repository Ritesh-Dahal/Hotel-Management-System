package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
