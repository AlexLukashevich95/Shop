package com.lukashevich.shop.service;

import com.lukashevich.shop.model.Product;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(String id);
}
