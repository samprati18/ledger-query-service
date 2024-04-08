package com.assignment.ledger.commandsync;

import com.assignment.ledger.dto.AccountViewDTO;
import com.assignment.ledger.dto.WalletViewDTO;
import com.assignment.ledger.entity.WalletView;
import com.assignment.ledger.mapper.EntityMapper;
import com.assignment.ledger.repository.WalletChangeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WalletChangeConsumer {
    private final WalletChangeRepository walletChangeRepository;
    private final ObjectMapper objectMapper;

    private final EntityMapper entityMapper;

    public WalletChangeConsumer(WalletChangeRepository walletChangeRepository, ObjectMapper objectMapper,EntityMapper entityMapper){
        this.walletChangeRepository=walletChangeRepository;
        this.objectMapper=objectMapper;
        this.entityMapper=entityMapper;
    }
    @KafkaListener(topics = "ledger-account-wallet-event", groupId = "ledger-group")
    public void consume(String message) {
        WalletView walletView = entityMapper.convertToEntity(mapMessageToWalletView(message));
        log.info("WalletView  {} " , walletView);
        walletChangeRepository.save(walletView);
    }
    public WalletViewDTO mapMessageToWalletView(String message) {
        try {
            return objectMapper.readValue(message, WalletViewDTO.class);
        } catch (Exception e) {
            // Handle the exception (e.g., log it) and return null or throw a custom exception
            e.printStackTrace();
            return null;
        }
    }
}
