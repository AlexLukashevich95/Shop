package com.lukashevich.shop.model;

public class ProductShop {

    private Long quantity;

    public ProductShop(Long quantity) {
        this.quantity = quantity;
    }

    public ProductShop() {
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
