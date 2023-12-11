package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShopRepositoryImpl extends BaseRepository<Shop> implements ShopRepository {

    private final Gson gson;

    public ShopRepositoryImpl() {
        this.gson = new GsonBuilder().create();
    }

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        return super.save(shop);
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        return super.getAll();
    }

    @Override
    public Shop getShopById(Long id) throws IOException {
        return super.getById(id);
    }

    @Override
    public Shop addProductToShop(Shop shop) throws IOException {
        File file = FileUtils.getOrCreateFile(Shop.class);

        String shopsJson = new String(Files.readAllBytes(Path.of(file.getPath())));

        Type type = new TypeToken<ArrayList<Shop>>() {
        }.getType();

        List<Shop> shops = new Gson().fromJson(shopsJson, type);

        if (shops != null) {
            for (Shop element : shops) {
                if (element.getId().equals(shop.getId())) {
                    shops.remove(element);
                    shops.add(shop);
                    break;
                }
            }
        }

        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(shops));
            writer.flush();
        }

        return shop;
    }

    @Override
    public List<ProductShop> getProductsInShop(Shop shop) {
        return shop.getProducts();
    }

}
