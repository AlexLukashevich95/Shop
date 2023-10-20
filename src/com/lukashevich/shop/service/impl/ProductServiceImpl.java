package com.lukashevich.shop.service.impl;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.repository.impl.ProductRepositoryImpl;
import com.lukashevich.shop.service.ProductService;

public class ProductServiceImpl implements ProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    @Override
    public Product saveProduct(Product product) {
        productRepository.saveProduct(product);
        return null;
    }
}
