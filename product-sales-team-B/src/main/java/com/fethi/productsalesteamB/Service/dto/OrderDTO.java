package com.fethi.productsalesteamB.Service.dto;



import com.fethi.productsalesteamB.domain.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDTO {
    private Long Id;
    private LocalDate orderDate;
    private BigDecimal totalCost;
    private OrderStatus orderStatus;
    private String customerIdentity;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerIdentity() {
        return customerIdentity;
    }

    public void setCustomerIdentity(String customerIdentity) {
        this.customerIdentity = customerIdentity;
    }
}
