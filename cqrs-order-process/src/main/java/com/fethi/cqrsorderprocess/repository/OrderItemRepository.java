package com.fethi.cqrsorderprocess.repository;

import com.fethi.cqrsorderprocess.document.OrderItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
    Optional<List<OrderItem>> findByOrderId(String orderId, Pageable pageable);



}
