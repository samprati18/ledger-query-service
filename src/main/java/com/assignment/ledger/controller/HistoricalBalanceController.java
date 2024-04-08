package com.assignment.ledger.controller;

import com.assignment.ledger.dto.HistoricalBalanceViewDTO;
import com.assignment.ledger.service.HistoricalBalanceViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoricalBalanceController {
    private final HistoricalBalanceViewService historicalBalanceViewService;

    @Autowired
    public HistoricalBalanceController(HistoricalBalanceViewService historicalBalanceViewService) {
        this.historicalBalanceViewService = historicalBalanceViewService;
    }

    @GetMapping("/historical-balances/{walletId}")
    public ResponseEntity<List<HistoricalBalanceViewDTO>> getHistoricalBalancesForWalletAtTimestamp(
            @PathVariable(value = "walletId") Long walletId,
            @RequestParam(value = "timestamp", required = false) String timestamp
    ) {
        List<HistoricalBalanceViewDTO> historicalBalances = historicalBalanceViewService.getHistoricalBalances(walletId, timestamp);
        return new ResponseEntity<>(historicalBalances, HttpStatus.OK);
    }
}
