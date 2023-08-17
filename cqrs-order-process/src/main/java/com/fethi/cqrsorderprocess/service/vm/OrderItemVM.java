package com.fethi.cqrsorderprocess.service.vm;

import java.math.BigDecimal;

public class OrderItemVM {
    private Integer quantity;

    private BigDecimal price;

    private ProductVM productVM;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductVM getProductVM() {
        return productVM;
    }

    public void setProductVM(ProductVM productVM) {
        this.productVM = productVM;
    }
}