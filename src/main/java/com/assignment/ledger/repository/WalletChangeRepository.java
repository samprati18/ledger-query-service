package com.assignment.ledger.repository;

import com.assignment.ledger.entity.WalletView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletChangeRepository extends JpaRepository<WalletView,Long> {
}
