package com.lukashevich.shop.service;

import com.lukashevich.shop.model.Shop;

import java.util.List;

public interface ShopService {
    Shop saveShop(Shop shop);
    List<Shop> getAllShops();
}
