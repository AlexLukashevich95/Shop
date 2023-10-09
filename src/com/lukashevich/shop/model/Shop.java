package com.lukashevich.shop.model;

import java.util.List;

public class Shop {

    private Long id;
    private String name;
    private String address;
    private List<Product> products;


    public Shop(Long id, String name, String address, List<Product> products) {
        this.id = id;
        this.name = name;
        this.address= address;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
