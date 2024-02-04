package com.lukashevich.shop.model;

public class ProductShop {

    private Long productId;
    private Integer quantity;

    public ProductShop(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public ProductShop() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
