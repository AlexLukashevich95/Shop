package com.lukashevich.shop.repository;


import com.lukashevich.shop.model.Product;

public interface ProductRepository {
    Product saveProduct(Product product);

    Product getProductById(String id);
}
