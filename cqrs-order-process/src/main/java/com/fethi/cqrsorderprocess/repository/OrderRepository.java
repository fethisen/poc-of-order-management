package com.fethi.cqrsorderprocess.repository;

import com.fethi.cqrsorderprocess.document.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
    Optional<List<Order>> findAllByCustomerIdentity(String identityNo, Pageable pageable);
}
