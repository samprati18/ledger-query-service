package com.assignment.ledger.commandsync;

import com.assignment.ledger.entity.HistoricalBalanceView;
import com.assignment.ledger.repository.HistoricalBalanceViewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HistoricalBalanceConsumer {

    private final HistoricalBalanceViewRepository historicalBalanceViewRepository;
    private final ObjectMapper objectMapper;

    public HistoricalBalanceConsumer(HistoricalBalanceViewRepository historicalBalanceViewRepository, ObjectMapper objectMapper){
        this.historicalBalanceViewRepository=historicalBalanceViewRepository;
        this.objectMapper=objectMapper;
    }

    @KafkaListener(topics = "ledger-historical-balance-event", groupId = "ledger-group")
    public void consume(String message) {
        // Assuming the message contains the updated account state information
        // Parse the message and update the account state in the database
        // For example:
        HistoricalBalanceView historicalBalanceView =  mapMessageToHistoricalBalanceView(message);
        log.info("historicalBalanceView view  {} " , historicalBalanceView);
        historicalBalanceViewRepository.save(historicalBalanceView);
    }
    public HistoricalBalanceView mapMessageToHistoricalBalanceView(String message) {
        try {
            return objectMapper.readValue(message, HistoricalBalanceView.class);
        } catch (Exception e) {
            // Handle the exception (e.g., log it) and return null or throw a custom exception
            e.printStackTrace();
            return null;
        }
    }
}
