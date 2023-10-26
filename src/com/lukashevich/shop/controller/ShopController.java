package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.service.ShopService;

import java.io.IOException;
import java.util.List;

public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    public Shop saveShop(Shop shop) throws IOException {
        shopService.saveShop(shop);
        return shop;
    }

    public List<Shop> getAllShops() throws IOException {
        shopService.getAllShops();
        return null;
    }
}
