package com.fethi.cqrsorderprocess.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {

    private String Id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Integer rating;
    private LocalDate date;

    public Product(String name, String description, BigDecimal price, Integer quantity, Integer rating,
                   LocalDate date) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
        this.date = date;
    }

    public Product(String name, String description, BigDecimal price, Integer quantity, Integer rating) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }



    public Product(String Id, String name, String description) {
        super();
        this.Id = Id;
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Product() {
        super();
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
