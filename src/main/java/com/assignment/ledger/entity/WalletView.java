package com.assignment.ledger.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "wallet_view")
public class WalletView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double balance;
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "asset_id")
    private Long assetId;

    public WalletView() {
    }
}
