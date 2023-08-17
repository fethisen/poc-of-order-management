package com.fethi.cqrsorderprocess.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "order")
public class Order {
    @Id
    private String id;

    @Field(name = "order_date")
    private LocalDate orderDate;

    @Field(name = "total_cost")
    private BigDecimal totalCost;

    @Field(name = "order_status")
    private String orderStatus;

    @Field(name = "customer_name")
    private String customerName;

    @Field(name = "customer_identity")
    private String customerIdentity;

    public Order(LocalDate orderDate, BigDecimal totalCost, String orderStatus, String customerName, String customerIdentity) {
        this.orderDate = orderDate;
        this.totalCost = totalCost;
        this.orderStatus = orderStatus;
        this.customerName = customerName;
        this.customerIdentity = customerIdentity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIdentity() {
        return customerIdentity;
    }

    public void setCustomerIdentity(String customerIdentity) {
        this.customerIdentity = customerIdentity;
    }
}
