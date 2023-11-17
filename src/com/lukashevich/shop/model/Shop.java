package com.lukashevich.shop.model;

import java.util.Date;
import java.util.List;

public class Shop extends BaseModel {
    private String name;
    private Long id_address;
    private List<Product> products;

    public Shop(Long id,String name, Long id_address, List<Product> products, Date dateOfAdding) {
        super(id, dateOfAdding);
        this.name=name;
        this.id_address = id_address;
        this.products = products;
    }

    public Shop() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getAddress() {
        return id_address;
    }

    public void setAddress(Long id_address) {
        this.id_address = id_address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
