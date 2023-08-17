package com.cqrs.pollingPublisher.service;

import com.cqrs.pollingPublisher.config.RabbitMQConfig;

import com.cqrs.pollingPublisher.domain.EventDesc;
import com.cqrs.pollingPublisher.repository.EventDescRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class EventHandlerService {
    private  final ObjectMapper OBJECT_MAPPER;

    private final RabbitMQConfig rabbitMQConfig;
    private final EventDescRepository eventDescRepository;

    public EventHandlerService(ObjectMapper objectMapper, RabbitMQConfig rabbitMQConfig, EventDescRepository eventDescRepository) {
        OBJECT_MAPPER = objectMapper;
        this.rabbitMQConfig = rabbitMQConfig;
        this.eventDescRepository = eventDescRepository;
    }

    @RabbitListener(queues = "#{rabbitMQConfig.getQueueNameListener()}")
    public void consume(String eventStr) {
        try{
            EventDesc event = OBJECT_MAPPER.readValue(eventStr, EventDesc.class);
            eventDescRepository.delete(event);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
