package com.lukashevich.shop.repository;

import com.lukashevich.shop.model.Shop;

import java.util.List;

public interface ShopRepository {
    Shop saveShop(Shop shop);

    List<Shop> getAllShops();
}
