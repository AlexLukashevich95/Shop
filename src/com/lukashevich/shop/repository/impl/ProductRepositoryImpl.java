package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.repository.ProductRepository;
import com.lukashevich.shop.utils.FileUtils;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product saveProduct(Product product) {
        Gson gson= new Gson();
        FileUtils fileUtils =new FileUtils();
        fileUtils.writeData("ProductData.txt",
                gson.toJson(product));
        return null;
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }
}
