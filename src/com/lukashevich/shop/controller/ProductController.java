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
        List<Product> products = new ArrayList<>();
        try {
            products = productService.getAllProducts();
        } catch (IOException e) {
            System.out.println(e);
        }
        return products;
    }

    public Product getProductById(Long id) {
        Product product = new Product();
        try {
            product = productService.getProductById(id);
        } catch (IOException e) {
            System.out.println(e);
        }
        return product;
    }

}
