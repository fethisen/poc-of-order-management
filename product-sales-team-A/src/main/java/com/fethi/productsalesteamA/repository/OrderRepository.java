package com.fethi.productsalesteamA.repository;

import com.fethi.productsalesteamA.domain.Order;
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
