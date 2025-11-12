package com.vehicle.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long dealerId;

  private Double amount;

  private String method;

  private String status;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
