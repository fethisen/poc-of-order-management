package com.fethi.productsalesteamB.repository;

import com.fethi.productsalesteamB.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByCustomerIdentity(Pageable pageable, Long identity);
    Page<Order> findByOrderDateBetween(Pageable pageable,Date startDate, Date endDate);
}
