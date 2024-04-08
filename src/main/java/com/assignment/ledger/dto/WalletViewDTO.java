package com.assignment.ledger.dto;

import com.assignment.ledger.entity.WalletView;
import lombok.Data;

@Data
public class WalletViewDTO {
    private Long id;
    private String name;
    private Long accountId;
    private Long assetId;
    private double balance;
}
