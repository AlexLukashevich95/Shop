package com.lukashevich.shop.service;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product) throws IOException;

    List<Product> getAllProducts() throws IOException;

    Product getProductById(Long id) throws IOException;
}
