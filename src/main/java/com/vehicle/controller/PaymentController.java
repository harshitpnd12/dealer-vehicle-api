package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Payment;
import com.vehicle.services.PaymentService;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PostMapping("/initiate")
  public ResponseEntity<Payment> initiate(@RequestBody Payment payment) {
    return ResponseEntity.ok(paymentService.initialPayment(payment));
  }

  @GetMapping
  public ResponseEntity<List<Payment>> getAllPayments() {
    return ResponseEntity.ok(paymentService.getAllPayments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
    return ResponseEntity.ok(paymentService.getPaymentById(id));
  }

  @GetMapping("/dealer/{dealerId}")
  public ResponseEntity<List<Payment>> getPaymentsByDealer(@PathVariable Long dealerId) {
    return ResponseEntity.ok(paymentService.getPaymentsByDealerId(dealerId));
  }
}