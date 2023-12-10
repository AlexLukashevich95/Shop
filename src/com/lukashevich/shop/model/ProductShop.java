package com.lukashevich.shop.model;

import java.util.Date;

public class ProductShop {

    private Long idShop;
    private Long idProduct;
    private Long quantity;

    public ProductShop(Long idShop, Long idProduct, Long quantity) {
        this.idShop = idShop;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public ProductShop() {
    }

    public Long getIdShop() {
        return idShop;
    }

    public void setIdShop(Long idShop) {
        this.idShop = idShop;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
