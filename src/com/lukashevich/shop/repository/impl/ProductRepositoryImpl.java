package com.lukashevich.shop.repository.impl;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.repository.ProductRepository;

import java.io.IOException;
import java.util.List;

public class ProductRepositoryImpl extends BaseRepository<Product> implements ProductRepository {

    public ProductRepositoryImpl() {
    }

    @Override
    public Product saveProduct(Product product) throws IOException {
        return super.save(product);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return super.getAll();
    }

    @Override
    public Product getProductById(Long id) throws IOException {
        return super.getById(id);
    }


}
