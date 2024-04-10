package com.assignment.ledger.commandsync;

import com.assignment.ledger.dto.MovementViewDTO;
import com.assignment.ledger.entity.AccountView;
import com.assignment.ledger.entity.MovementView;
import com.assignment.ledger.mapper.EntityMapper;
import com.assignment.ledger.repository.AccountRepository;
import com.assignment.ledger.repository.AssetMovementRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AssetMovementChangeConsumer {

    private final AssetMovementRepository assetMovementRepository;
    private final ObjectMapper objectMapper;

    private final EntityMapper entityMapper;

    public AssetMovementChangeConsumer(AssetMovementRepository assetMovementRepository,ObjectMapper objectMapper,EntityMapper entityMapper) {
        this.assetMovementRepository = assetMovementRepository;
        this.objectMapper=objectMapper;
        this.entityMapper=entityMapper;
    }

    @KafkaListener(topics = "${ledger.asset.movement.event.topic}", groupId = "${ledger.consumer.group.id}")
    public void consume(String message) {
        // Assuming the message contains the updated account state information
        // Parse the message and update the account state in the database
        // For example:
        MovementView movementView =  entityMapper.convertToEntity(mapMessageToMovementView(message));
        log.info("AssetMovement view  {} " , movementView);
        assetMovementRepository.save(movementView);
    }

    public MovementViewDTO mapMessageToMovementView(String message) {
        try {
            return objectMapper.readValue(message, MovementViewDTO.class);
        } catch (Exception e) {
            // Handle the exception (e.g., log it) and return null or throw a custom exception
            e.printStackTrace();
            return null;
        }
    }
}
