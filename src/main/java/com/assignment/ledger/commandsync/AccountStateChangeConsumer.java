package com.assignment.ledger.commandsync;

import com.assignment.ledger.dto.AccountViewDTO;
import com.assignment.ledger.entity.AccountView;
import com.assignment.ledger.mapper.EntityMapper;
import com.assignment.ledger.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountStateChangeConsumer {

    private final AccountRepository accountRepository;
    private final ObjectMapper objectMapper;

    private final EntityMapper entityMapper;



    public AccountStateChangeConsumer(AccountRepository accountRepository,ObjectMapper objectMapper,EntityMapper entityMapper) {
        this.accountRepository = accountRepository;
        this.objectMapper=objectMapper;
        this.entityMapper = entityMapper;
    }

    @KafkaListener(topics = "${ledger.account.state.change.event.topic}", groupId = "${ledger.consumer.group.id}")
    public void consume(String message) {
        // Assuming the message contains the updated account state information
        // Parse the message and update the account state in the database
        // For example:
        AccountView accountView = entityMapper.convertToEntity(mapMessageToAccountView(message));
        log.info("Account view  {} " , accountView);
        accountRepository.updateAccountState(accountView.getAccountNumber(), accountView.getState());
    }

    public AccountViewDTO mapMessageToAccountView(String message) {
        try {
            return objectMapper.readValue(message, AccountViewDTO.class);
        } catch (Exception e) {
            // Handle the exception (e.g., log it) and return null or throw a custom exception
            e.printStackTrace();
            return null;
        }
    }
}
