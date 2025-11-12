package com.vehicle.services;

import java.util.List;

import com.vehicle.entity.Dealer;

public interface DealerService {

  Dealer createDealer(Dealer dealer);

  Dealer updateDealer(Long id, Dealer dealer);

  void deleteDealer(Long id);

  Dealer getDealerById(Long id);

  List<Dealer> getAllDealers();
}
