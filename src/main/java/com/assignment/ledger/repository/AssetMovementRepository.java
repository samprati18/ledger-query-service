package com.assignment.ledger.repository;

import com.assignment.ledger.entity.MovementView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetMovementRepository extends JpaRepository<MovementView, Long> {
}
