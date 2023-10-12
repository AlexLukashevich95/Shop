package com.lukashevich.shop.repository;

import com.lukashevich.shop.model.Shop;

public interface ShopRepository {
    Shop saveShop(Shop shop);

    Shop getShopById(String id);
}
