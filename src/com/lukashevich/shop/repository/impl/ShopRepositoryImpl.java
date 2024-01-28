package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;

import java.io.IOException;
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

}
