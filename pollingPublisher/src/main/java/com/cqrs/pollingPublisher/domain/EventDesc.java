package com.cqrs.pollingPublisher.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "outbox")
public class EventDesc {
    @Id
    private UUID id;

    @Column(length = 10000)
    private String orderContent;
    @Column(length = 10000)
    private String orderItemContent;
    private LocalDate createTime;
    private String type;
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.CREATED;
    public enum Status {
        CREATED, PUBLISHED;
    }

    public EventDesc() {
    }

    public EventDesc(UUID id, String orderContent, String orderItemContent, LocalDate createTime, String type) {
        this.id = id;
        this.orderContent = orderContent;
        this.orderItemContent = orderItemContent;
        this.createTime = createTime;
        this.type = type;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getOrderItemContent() {
        return orderItemContent;
    }

    public void setOrderItemContent(String orderItemContent) {
        this.orderItemContent = orderItemContent;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
