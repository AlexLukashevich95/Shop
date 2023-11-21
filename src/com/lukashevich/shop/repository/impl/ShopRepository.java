package com.lukashevich.shop.repository.impl;

import com.lukashevich.shop.model.Shop;


import java.io.IOException;

import java.util.List;

public class ShopRepository extends BaseRepository<Shop> implements com.lukashevich.shop.repository.ShopRepository {

    public ShopRepository() {
    }

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        return super.save(shop);
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        return super.getAll();
    }

}
