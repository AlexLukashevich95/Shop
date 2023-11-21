package com.lukashevich.shop.model;

import java.util.Date;

public class Product extends BaseModel {
    private Long price;
    private String name;
    private Long quantity;
    private String type;

    public Product(Long id, String name, Long price, Long quantity, String type, Date dateOfAdding) {
        super(id, dateOfAdding);
        this.name=name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
