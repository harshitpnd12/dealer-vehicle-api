package com.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
  List<Payment> findByDealerId(Long dealerId);
}