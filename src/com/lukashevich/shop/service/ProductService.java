package com.lukashevich.shop.service;

import com.lukashevich.shop.model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts() throws IOException;
}
