package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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

public class ShopRepositoryImpl implements ShopRepository {
    private final Gson gson;

    public ShopRepositoryImpl() {
        this.gson = new GsonBuilder().create();
    }

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        File file = FileUtils.getOrCreateFile("ShopData.json");
        List<Shop> shops = getAllShops();
        shop.setId((long) shops.size() + 1);
        shops.add(shop);
        FileWriter writer = new FileWriter(file, false);
        writer.write(gson.toJson(shops));
        writer.flush();
        writer.close();
        return shop;
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        File file = FileUtils.getOrCreateFile("ShopData.json");
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        String shopsJson = new String(Files.readAllBytes(Path.of(file.getPath())));
        Type type = new TypeToken<ArrayList<Shop>>() {
        }.getType();
        return gson.fromJson(shopsJson, type);
    }

}
