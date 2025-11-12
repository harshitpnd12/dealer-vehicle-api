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

import com.vehicle.entity.Vehicle;
import com.vehicle.enums.SubscriptionType;
import com.vehicle.services.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
  @Autowired
  private VehicleService vehicleService;

  @PostMapping
  public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
    return ResponseEntity.ok(vehicleService.createVehicle(vehicle));
  }

  @GetMapping
  public ResponseEntity<List<Vehicle>> getAllVehicles() {
    return ResponseEntity.ok(vehicleService.getAllVehicle());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
    return ResponseEntity.ok(vehicleService.getVehicleById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
    return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicle));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
    vehicleService.deleteVehicle(id);
    return ResponseEntity.ok("Vehicle deleted successfully");
  }

  @GetMapping("/premium")
  public ResponseEntity<List<Vehicle>> getVehiclesOfPremiumDealers() {
    return ResponseEntity.ok(vehicleService.getVehiclesBYDealerType(SubscriptionType.PREMIUM));
  }
}
