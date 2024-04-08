package com.assignment.ledger.dto;

import lombok.Data;

@Data
public class MovementViewDTO {
    private Long id;
    private Long sourceWalletId;
    private Long destinationWalletId;
    private double amount;
    private String timestamp;
    private String state;
}
