package com.lukashevich.shop.service.impl;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.repository.ProductRepository;
import com.lukashevich.shop.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) throws IOException {
        return productRepository.saveProduct(product);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(Long id) throws IOException {
        return productRepository.getProductById(id);
    }
}
