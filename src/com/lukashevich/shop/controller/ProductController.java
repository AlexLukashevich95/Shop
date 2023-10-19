package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.service.impl.ProductServiceImpl;

public class ProductController {
    ProductServiceImpl productService = new ProductServiceImpl();

    public Product saveProduct(Product product){
        return productService.saveProduct(product);
    }
}
