package com.lukashevich.shop.service;

import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.List;

public interface ShopService {
    Shop saveShop(Shop shop) throws IOException;
    List<Shop> getAllShops() throws IOException;
}
