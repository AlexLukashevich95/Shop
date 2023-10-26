package com.lukashevich.shop.service.impl;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.repository.ProductRepository;
import com.lukashevich.shop.repository.impl.ProductRepositoryImpl;
import com.lukashevich.shop.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    public ProductServiceImpl(ProductRepository productRepository) {
    }

    @Override
    public Product saveProduct(Product product) throws IOException {
        productRepository.saveProduct(product);
        return null;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productRepository.getAllProducts();
    }
}
