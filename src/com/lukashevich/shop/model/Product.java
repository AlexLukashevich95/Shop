package com.lukashevich.shop.model;

import java.util.Date;

public class Product extends BaseModel {
    private String name;
    private Long price;
    private String type;

    public Product(Long id, Date dateOfAdding, String name, Long price, String type) {
        super(id, dateOfAdding);
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
