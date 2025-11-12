package com.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {

}
