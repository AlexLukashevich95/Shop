package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.repository.ProductRepository;
import com.lukashevich.shop.utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final Gson gson;
    private final FileUtils fileUtils;

    public ProductRepositoryImpl() {
        this.gson = new GsonBuilder().create();
        this.fileUtils = new FileUtils();
    }

    @Override
    public Product saveProduct(Product product) throws IOException {
        File file = fileUtils.getOrCreateFile(Product.class);
        List<Product> products = getAllProducts();
        product.setId((long) products.size() + 1);
        products.add(product);
        FileWriter writer = new FileWriter(file, false);
        writer.write(gson.toJson(products));
        writer.flush();
        writer.close();
        return product;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        File file = fileUtils.getOrCreateFile(Product.class);
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        String productsJson = new String(Files.readAllBytes(Path.of(file.getPath())));
        Type type = new TypeToken<ArrayList<Product>>() {
        }.getType();
        return gson.fromJson(productsJson, type);
    }
}
