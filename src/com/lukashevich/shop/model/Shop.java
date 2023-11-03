package com.lukashevich.shop.model;

import java.util.Date;
import java.util.List;

public class Shop extends Model {
    private String address;
    private List<Product> products;

    public Shop(Long id, String name, String address, List<Product> products, Date dateOfAdding) {
        super(id, name, dateOfAdding);
        this.address = address;
        this.products = products;
    }

    public Shop() {
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
