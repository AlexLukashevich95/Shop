package com.lukashevich.shop.model;

import java.util.Date;
import java.util.List;

public class Shop extends BaseModel {
    private String name;
    private Address address;
    private List<Product> products;

    public Shop() {
    }

    public Shop(Long id, Date dateOfAdding, String name, Address address, List<Product> products) {
        super(id, dateOfAdding);
        this.name = name;
        this.address = address;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
