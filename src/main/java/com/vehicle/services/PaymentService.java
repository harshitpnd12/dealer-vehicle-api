package com.vehicle.services;

import java.util.List;

import com.vehicle.entity.Payment;

public interface PaymentService {
  Payment initialPayment(Payment payment);

  Payment getPaymentById(Long id);

  List<Payment> getAllPayments();

  List<Payment> getPaymentsByDealerId(Long dealerId);
}