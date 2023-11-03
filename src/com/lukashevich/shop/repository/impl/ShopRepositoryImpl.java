package com.lukashevich.shop.repository.impl;

import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.AbstractFileRepository;
import com.lukashevich.shop.repository.ShopRepository;

import java.io.IOException;
import java.util.List;

public class ShopRepositoryImpl extends AbstractFileRepository<Shop> implements ShopRepository {

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        return super.saveModel(shop);
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        return super.getAllModels();
    }
}
