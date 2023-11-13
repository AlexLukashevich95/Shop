package com.lukashevich.shop.repository.impl;

import com.lukashevich.shop.model.Product;

import java.io.IOException;
import java.util.List;

public class ProductRepository extends BaseRepository<Product> implements com.lukashevich.shop.repository.ProductRepository {

    public ProductRepository() {
    }

    @Override
    public Product saveProduct(Product product) throws IOException {
        return super.save(product);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return super.getAll();
    }


}
