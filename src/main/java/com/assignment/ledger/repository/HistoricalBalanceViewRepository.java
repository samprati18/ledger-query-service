package com.assignment.ledger.repository;

import com.assignment.ledger.entity.HistoricalBalanceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoricalBalanceViewRepository extends JpaRepository<HistoricalBalanceView, Long> {
    @Query("SELECT hb FROM HistoricalBalanceView hb WHERE hb.walletId = :walletId AND (:timestamp IS NULL OR hb.timestamp = :timestamp)")
    List<HistoricalBalanceView> findByWalletIdAndTimestamp(@Param("walletId") Long walletId, @Param("timestamp") String timestamp);
}
