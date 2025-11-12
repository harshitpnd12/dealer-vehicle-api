package com.vehicle.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.entity.Dealer;
import com.vehicle.repository.DealerRepository;
import com.vehicle.services.DealerService;

@Service
public class DealerServiceImpl implements DealerService {

  @Autowired
  private DealerRepository dealerRepository;

  @Override
  public Dealer createDealer(Dealer dealer) {
    return dealerRepository.save(dealer);
  }

  @Override
  public Dealer updateDealer(Long id, Dealer dealer) {
    Dealer exiting = dealerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Dealer not found Exception" + id));
    exiting.setName(dealer.getName());
    exiting.setEmail(dealer.getEmail());
    exiting.setSubscriptionType(dealer.getSubscriptionType());
    return dealerRepository.save(exiting);
  }

  @Override
  public void deleteDealer(Long id) {
    dealerRepository.deleteById(id);
  }

  @Override
  public Dealer getDealerById(Long id) {
    return dealerRepository.findById(id).orElseThrow(() -> new RuntimeException("Dealer not found with id: " + id));
  }

  @Override
  public List<Dealer> getAllDealers() {
    return dealerRepository.findAll();
  }

}
