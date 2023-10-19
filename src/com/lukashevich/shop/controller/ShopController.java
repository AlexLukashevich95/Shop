package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.service.ShopService;

public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    public Shop saveShop(Shop shop){
        shopService.saveShop(shop);
        return shop;
    }

    public Shop getShopById(String id){
        shopService.getShopByID(id);
        return null;
    }
}
