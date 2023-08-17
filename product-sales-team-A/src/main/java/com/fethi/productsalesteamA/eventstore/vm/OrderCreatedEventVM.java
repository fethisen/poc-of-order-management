package com.fethi.productsalesteamA.eventstore.vm;

import com.fethi.productsalesteamA.Service.dto.OrderDTO;

import java.util.List;

public class OrderCreatedEventVM {
    OrderVM orderVM;
    List<OrderItemVM> orderItemVMList;

    public OrderVM getOrderVM() {
        return orderVM;
    }

    public void setOrderVM(OrderVM orderVM) {
        this.orderVM = orderVM;
    }

    public List<OrderItemVM> getOrderItemVMList() {
        return orderItemVMList;
    }

    public void setOrderItemVMList(List<OrderItemVM> orderItemVMList) {
        this.orderItemVMList = orderItemVMList;
    }
}
