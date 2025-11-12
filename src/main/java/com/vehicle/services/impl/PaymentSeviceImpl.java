package com.vehicle.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vehicle.entity.Payment;
import com.vehicle.repository.PaymentRepository;
import com.vehicle.services.PaymentService;

@Service
public class PaymentSeviceImpl implements PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  @Override
  public Payment initialPayment(Payment payment) {
    payment.setStatus("PENDING");
    payment.setCreatedAt(LocalDateTime.now());
    payment.setUpdatedAt(LocalDateTime.now());
    Payment saved = paymentRepository.save(payment);
    simulatePaymentSuccess(saved.getId());

    return saved;
  }

  @Async
  public void simulatePaymentSuccess(Long paymentId) {
    try {
      Thread.sleep(5000);
      Payment p = paymentRepository.findById(paymentId).orElseThrow();
      p.setStatus("SUCCESS");
      p.setUpdatedAt(LocalDateTime.now());
      paymentRepository.save(p);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Payment getPaymentById(Long id) {
    return paymentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
  }

  @Override
  public List<Payment> getAllPayments() {
    return paymentRepository.findAll();
  }

  @Override
  public List<Payment> getPaymentsByDealerId(Long dealerId) {
    return paymentRepository.findByDealerId(dealerId);
  }
}