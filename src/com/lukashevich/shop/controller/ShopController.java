package com.lukashevich.shop.controller;

import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.service.ShopService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    public Shop saveShop(Shop shop) {
        try {
            shopService.saveShop(shop);
        } catch (IOException e) {
            System.out.println(e);
        }
        return shop;
    }

    public List<Shop> getAllShops() {
        List<Shop> list = new ArrayList<>();
        try {
            list = shopService.getAllShops();
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }

    public Shop getShopById(Long id) {
        Shop shop = new Shop();
        try {
            shop = shopService.getShopById(id);
        } catch (IOException e) {
            System.out.println(e);
        }
        return shop;
    }

    public Shop addProductToShop(Shop shop) {
        try {
            return shopService.addProductToShop(shop);
        } catch (IOException e) {
            System.out.println(e);
        }
        return shop;
    }

    public List<ProductShop> getProductsInShop(Shop shop) {
        return shopService.getProductsInShop(shop);
    }
}
