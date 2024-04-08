package com.assignment.ledger.dto;

import com.assignment.ledger.entity.HistoricalBalanceView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HistoricalBalanceViewDTO {
    private Long id;
    private Long walletId;
    private double balance;
    private String timestamp;
}
