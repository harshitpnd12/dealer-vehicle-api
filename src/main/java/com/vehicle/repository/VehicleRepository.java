package com.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehicle.entity.Vehicle;
import com.vehicle.enums.SubscriptionType;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  @Query("SELECT v FROM Vehicle v WHERE v.dealer.subscriptionType = :subscriptionType")
  List<Vehicle> findByDealerSubscriptionType(SubscriptionType subscriptionType);
}
