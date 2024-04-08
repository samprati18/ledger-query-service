package com.assignment.ledger.repository;

import com.assignment.ledger.entity.AccountState;
import com.assignment.ledger.entity.AccountView;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountView, Long> {

    // Add method declaration for updating account state
    // Method declaration for updating account state
    @Modifying
    @Transactional
    @Query("UPDATE AccountView a SET a.state = :newState WHERE a.accountNumber = :accountNumber")
    void updateAccountState(String accountNumber, String newState);
}
