package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product saveProduct(Product product) {
        try {
            productService.saveProduct(product);
        } catch (IOException e) {
            System.out.println(e);
        }
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            list = productService.getAllProducts();
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }
}
