package com.cqrs.pollingPublisher.service;

import com.cqrs.pollingPublisher.config.RabbitMQConfig;
import com.cqrs.pollingPublisher.domain.EventDesc;
import com.cqrs.pollingPublisher.repository.EventDescRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventPublisherService {
    private final ObjectMapper OBJECT_MAPPER;

    private final EventDescRepository eventDescRepository;
    private final RabbitTemplate rabbitTemplate;

    private final RabbitMQConfig rabbitMQConfig;

    public EventPublisherService(ObjectMapper objectMapper, EventDescRepository eventDescRepository, RabbitTemplate rabbitTemplate, RabbitMQConfig rabbitMQConfig) {
        OBJECT_MAPPER = objectMapper;
        this.eventDescRepository = eventDescRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQConfig = rabbitMQConfig;
    }

    @PostConstruct
    public void init() {
        List<EventDesc> eventList = eventDescRepository.findByStatus(EventDesc.Status.PUBLISHED);
        eventList.forEach(event -> {event.setStatus(EventDesc.Status.CREATED);eventDescRepository.save(event);});
    }

    @Scheduled(fixedRate = 3000)
    public void publishAllPeriodically() {
        List<EventDesc> eventList = toPublish();
        eventList.forEach(this::raiseEvent);
        markAsPublished(eventList, EventDesc.Status.PUBLISHED);

    }

    private List<EventDesc> toPublish() {
        return eventDescRepository.findByStatus(EventDesc.Status.CREATED);
    }

    private void raiseEvent(EventDesc event) {
        try {
            String value = OBJECT_MAPPER.writeValueAsString(event);
            rabbitTemplate.convertAndSend(rabbitMQConfig.getExchangeName(), rabbitMQConfig.getRoutingKeyPublisher(), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void markAsPublished(List<EventDesc> events, EventDesc.Status status) {
        if (CollectionUtils.isEmpty(events)) return;
        eventDescRepository.markAsPublished(
                events.stream()
                        .map(EventDesc::getId)
                        .collect(Collectors.toList())
                , status
        );
    }
}
