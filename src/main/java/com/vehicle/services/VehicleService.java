package com.vehicle.services;

import java.util.List;

import com.vehicle.entity.Vehicle;
import com.vehicle.enums.SubscriptionType;

public interface VehicleService {

  Vehicle createVehicle(Vehicle vehicle);

  Vehicle updateVehicle(Long id, Vehicle vehicle);

  void deleteVehicle(Long id);

  Vehicle getVehicleById(Long id);

  List<Vehicle> getAllVehicle();

  List<Vehicle> getVehiclesBYDealerType(SubscriptionType subscriptionType);
}
