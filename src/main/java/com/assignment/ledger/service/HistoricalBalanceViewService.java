package com.assignment.ledger.service;

import com.assignment.ledger.dto.HistoricalBalanceViewDTO;
import com.assignment.ledger.entity.HistoricalBalanceView;
import com.assignment.ledger.repository.HistoricalBalanceViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricalBalanceViewService {
    private final HistoricalBalanceViewRepository historicalBalanceViewRepository;

    @Autowired
    public HistoricalBalanceViewService(HistoricalBalanceViewRepository historicalBalanceViewRepository) {
        this.historicalBalanceViewRepository = historicalBalanceViewRepository;
    }

    public List<HistoricalBalanceViewDTO> getHistoricalBalances(Long walletId, String timestamp) {
        return transformToDTO(historicalBalanceViewRepository.findByWalletIdAndTimestamp(walletId, timestamp));
    }

    public List<HistoricalBalanceViewDTO> transformToDTO(List<HistoricalBalanceView> historicalBalanceViews) {
        return historicalBalanceViews.stream()
                .map(historicalBalanceView -> {
                    HistoricalBalanceViewDTO dto = new HistoricalBalanceViewDTO();
                    dto.setId(historicalBalanceView.getId());
                    dto.setWalletId(historicalBalanceView.getWalletId());
                    dto.setBalance(historicalBalanceView.getBalance());
                    dto.setTimestamp(historicalBalanceView.getTimestamp());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
