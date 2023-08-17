package com.fethi.cqrsorderprocess.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fethi.cqrsorderprocess.config.RabbitMQConfig;
import com.fethi.cqrsorderprocess.document.Order;
import com.fethi.cqrsorderprocess.service.dto.EventDescDTO;
import com.fethi.cqrsorderprocess.service.vm.OrderItemVM;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class OrderEventHandlerService {
    private final ObjectMapper objectMapper;
    private final RabbitMQConfig rabbitMQConfig;
    private final RabbitTemplate rabbitTemplate;
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    public OrderEventHandlerService(ObjectMapper objectMapper, RabbitMQConfig rabbitMQConfig, RabbitTemplate rabbitTemplate, OrderService orderService, OrderItemService orderItemService) {
        this.objectMapper = objectMapper;
        this.rabbitMQConfig = rabbitMQConfig;
        this.rabbitTemplate = rabbitTemplate;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @RabbitListener(queues = "#{rabbitMQConfig.getQueueNameListener()}")
    public void consume(String eventStr) {
        try{
            EventDescDTO event = objectMapper.readValue(eventStr, EventDescDTO.class);

            Order order = objectMapper.readValue(event.getOrderContent(), Order.class);
            List<OrderItemVM> orderItem = objectMapper.readValue(event.getOrderItemContent(), new TypeReference<List<OrderItemVM>>() {});
            order = orderService.saveOrder(order);
            orderItemService.saveOrderItem(orderItem, order);
            rabbitTemplate.convertAndSend(rabbitMQConfig.getExchangeName(), rabbitMQConfig.getRoutingKeyPublisher(), eventStr);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
