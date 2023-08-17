package com.fethi.cqrsorderprocess.service;

import com.fethi.cqrsorderprocess.document.Order;
import com.fethi.cqrsorderprocess.repository.OrderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllWithPagination (int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return orderRepository.findAll(pageable).getContent();
    }

    public List<Order> getAllOrderByCustomer(String identityNo,int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo- 1, pageSize);
        return orderRepository.findAllByCustomerIdentity(identityNo, pageable).orElseThrow( () -> new RuntimeException("Order not found!") );
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
