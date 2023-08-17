package com.fethi.productsalesteamA.eventstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fethi.productsalesteamA.eventstore.vm.OrderCreatedEventVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class EventStoreService {
    private final EventRepository eventRepository;
    private final ObjectMapper objectMapper;

    public EventStoreService(EventRepository eventRepository, ObjectMapper objectMapper) {
        this.eventRepository = eventRepository;
        this.objectMapper = objectMapper;
    }

    public void saveOrder(OrderCreatedEventVM orderCreatedEventVM) throws JsonProcessingException {
        eventRepository.save(
                new EventDesc(UUID.randomUUID(),
                        serialize(orderCreatedEventVM.getOrderVM()),
                        serialize(orderCreatedEventVM.getOrderItemVMList()),
                        LocalDate.now(),
                        "order-created")
        );
    }


    private String serialize(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }
}
