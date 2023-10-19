package com.lukashevich.shop.service;

import com.lukashevich.shop.model.Shop;

public interface ShopService {
    Shop saveShop(Shop shop);
    Shop getShopByID(String id);
}
