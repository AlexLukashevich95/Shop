package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
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
    Gson gson= new Gson();
    FileUtils fileUtils = new FileUtils();

    @Override
    public Product saveProduct(Product product) {

        File file=fileUtils.getOrCreateFile("ProductData.json");
        try(FileWriter writer = new FileWriter(file, false))
        {
            List<Product> products = getAllProducts();
            product.setId((long) products.size()+1);
            products.add(product);
            writer.write(gson.toJson(products));
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        File file=fileUtils.getOrCreateFile("ProductData.json");
        if (file.length()==0){
            return new ArrayList<>();
        }
        String productsJson =new String(Files.readAllBytes(Path.of(file.getPath())));
        Type type = new TypeToken<ArrayList<Product>>(){}.getType();
        return gson.fromJson(productsJson, type);
    }


}
