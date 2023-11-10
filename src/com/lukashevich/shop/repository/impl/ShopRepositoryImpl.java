package com.lukashevich.shop.repository.impl;

import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;


import java.io.IOException;

import java.util.List;

public class ShopRepositoryImpl extends AbstractRepositoryImpl implements ShopRepository  {

    public ShopRepositoryImpl() {
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
