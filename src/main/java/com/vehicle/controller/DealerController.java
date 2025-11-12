package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Dealer;
import com.vehicle.services.DealerService;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {

  @Autowired
  private DealerService dealerService;

  @PostMapping
  public ResponseEntity<Dealer> createDealer(@RequestBody Dealer dealer) {
    return ResponseEntity.ok(dealerService.createDealer(dealer));
  }

  @GetMapping
  public ResponseEntity<List<Dealer>> getAllDealer() {
    return ResponseEntity.ok(dealerService.getAllDealers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
    return ResponseEntity.ok(dealerService.getDealerById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Dealer> updateDealer(@PathVariable Long id, @RequestBody Dealer dealer) {
    return ResponseEntity.ok(dealerService.updateDealer(id, dealer));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteDealer(@PathVariable Long id) {
    dealerService.deleteDealer(id);
    return ResponseEntity.ok("Dealer deleted successfully");
  }

}
