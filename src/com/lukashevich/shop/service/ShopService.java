package com.lukashevich.shop.service;

import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ShopService {
    Shop saveShop(Shop shop) throws IOException;

    List<Shop> getAllShops() throws IOException;

    Shop getShopById(Long id) throws IOException;
}
