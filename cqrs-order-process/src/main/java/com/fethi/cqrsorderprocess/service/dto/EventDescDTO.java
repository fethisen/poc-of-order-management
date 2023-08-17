package com.fethi.cqrsorderprocess.service.dto;

import java.time.LocalDate;
import java.util.UUID;

public class EventDescDTO {
    private UUID id;
    private String orderContent;
    private String orderItemContent;
    private LocalDate createTime;
    private String type;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
