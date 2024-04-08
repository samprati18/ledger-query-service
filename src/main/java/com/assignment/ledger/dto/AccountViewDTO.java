package com.assignment.ledger.dto;

import com.assignment.ledger.entity.AccountState;
import com.assignment.ledger.entity.AccountView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountViewDTO {
    private Long id;
    private String accountNumber;
    private Long entityId;
    private String entityName; // Name of the entity associated with this account
    private String name;
    private String state;
}
