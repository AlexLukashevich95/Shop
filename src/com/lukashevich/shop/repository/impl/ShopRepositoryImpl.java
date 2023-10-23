package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.utils.FileUtils;

import java.util.List;

public class ShopRepositoryImpl implements ShopRepository {
    Gson gson;
    FileUtils fileUtils;

    public ShopRepositoryImpl() {
        this.gson= new GsonBuilder().create();
        this.fileUtils = new FileUtils();
    }

    @Override
    public Shop saveShop(Shop shop) {
        return null;
    }

    @Override
    public List<Shop> getAllShops() {
        return null;
    }
}
