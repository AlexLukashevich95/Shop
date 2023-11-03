package com.lukashevich.shop.repository.impl;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.repository.AbstractFileRepository;
import com.lukashevich.shop.repository.ProductRepository;

import java.io.IOException;
import java.util.List;

public class ProductRepositoryImpl extends AbstractFileRepository<Product> implements ProductRepository {

    @Override
    public Product saveProduct(Product product) throws IOException {
        return super.saveModel(product);
    }

    public List<Product> getAllProducts() throws IOException {
        return super.getAllModels();
    }
}
