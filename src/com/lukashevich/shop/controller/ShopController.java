package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.service.impl.ShopServiceImpl;

public class ShopController {
    ShopServiceImpl shopService = new ShopServiceImpl();

    public Shop saveShop(Shop shop){
        shopService.saveShop(shop);
        return shop;
    }
}
