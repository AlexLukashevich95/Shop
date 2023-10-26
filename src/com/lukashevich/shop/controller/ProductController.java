package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductController {
    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product saveProduct(Product product) throws IOException {
        productService.saveProduct(product);
        return product;
    }

    public List<Product> getAllProducts() throws IOException {
        return productService.getAllProducts();
    }
}
