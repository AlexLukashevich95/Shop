package com.lukashevich.shop.repository;


import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.List;

public interface ProductRepository {
    Product saveProduct(Product product) throws IOException;

    List<Product> getAllProducts() throws IOException;

    Product getProductById(Long id) throws IOException;
}
