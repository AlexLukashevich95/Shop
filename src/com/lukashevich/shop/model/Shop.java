package com.lukashevich.shop.model;

import java.util.Date;
import java.util.List;

public class Shop extends BaseModel {
    private String name;
    private Address address;
    private List<ProductShop> products;

    public Shop(Long id, String name, Address address, List<ProductShop> products, Date dateOfAdding) {
        super(id, dateOfAdding);
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ProductShop> getProducts() {
        return products;
    }

    public void setProducts(List<ProductShop> products) {
        this.products = products;
    }
}
