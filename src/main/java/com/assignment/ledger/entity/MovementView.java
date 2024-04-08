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
@Table(name = "movement_view")
public class MovementView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_wallet_id")
    private Long sourceWalletId;

    @Column(name = "destination_wallet_id")
    private Long destinationWalletId;

    private double amount;
    private String timestamp;
    private String state;

    public MovementView(){}
}
