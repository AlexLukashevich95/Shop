package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductController {
    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product saveProduct(Product product){
        return productService.saveProduct(product);
    }

    public List<Product> getAllProducts() throws IOException {
        return productService.getAllProducts();
    }
}
