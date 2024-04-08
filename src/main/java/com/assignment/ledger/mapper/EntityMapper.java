package com.assignment.ledger.mapper;

import com.assignment.ledger.dto.AccountViewDTO;
import com.assignment.ledger.dto.HistoricalBalanceViewDTO;
import com.assignment.ledger.dto.MovementViewDTO;
import com.assignment.ledger.dto.WalletViewDTO;
import com.assignment.ledger.entity.AccountView;
import com.assignment.ledger.entity.HistoricalBalanceView;
import com.assignment.ledger.entity.MovementView;
import com.assignment.ledger.entity.WalletView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;


@Component
public class EntityMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public EntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AccountView convertToEntity(AccountViewDTO accountViewDTO) {
        return modelMapper.map(accountViewDTO, AccountView.class);
    }

    public MovementView convertToEntity(MovementViewDTO movementViewDTO) {
        return modelMapper.map(movementViewDTO, MovementView.class);
    }

    public WalletView convertToEntity(WalletViewDTO walletViewDTO) {
        return modelMapper.map(walletViewDTO, WalletView.class);
    }

    public HistoricalBalanceView convertToEntity(HistoricalBalanceViewDTO historicalBalanceViewDTO) {
        return modelMapper.map(historicalBalanceViewDTO, HistoricalBalanceView.class);
    }

}
