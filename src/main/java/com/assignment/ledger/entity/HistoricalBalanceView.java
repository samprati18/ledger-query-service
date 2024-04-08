package com.assignment.ledger.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "historical_balance_view")
public class HistoricalBalanceView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wallet_id")
    private Long walletId;

    private double balance;
    private String timestamp;

    public HistoricalBalanceView(){}
}
