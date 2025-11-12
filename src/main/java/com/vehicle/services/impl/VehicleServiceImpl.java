package com.vehicle.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.entity.Vehicle;
import com.vehicle.enums.SubscriptionType;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Override
  public Vehicle createVehicle(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  @Override
  public Vehicle updateVehicle(Long id, Vehicle vehicle) {
    Vehicle exiting = vehicleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Vehicle not found with id" + id));
    exiting.setDealer(vehicle.getDealer());
    exiting.setModel(vehicle.getModel());
    exiting.setPrice(vehicle.getPrice());
    exiting.setStatus(vehicle.getStatus());
    return vehicleRepository.save(exiting);
  }

  @Override
  public void deleteVehicle(Long id) {
    vehicleRepository.deleteById(id);
  }

  @Override
  public Vehicle getVehicleById(Long id) {
    return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found with id" + id));
  }

  @Override
  public List<Vehicle> getAllVehicle() {
    return vehicleRepository.findAll();
  }

  @Override
  public List<Vehicle> getVehiclesBYDealerType(SubscriptionType subscriptionType) {
    return vehicleRepository.findByDealerSubscriptionType(subscriptionType);
  }

}
