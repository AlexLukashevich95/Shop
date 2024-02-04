package com.lukashevich.shop.controller;

import com.lukashevich.shop.dto.ProductShopDTO;
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

    public Shop addProductToShop(Long shopId, Long productId, ProductShop productShop) {
        Shop shop = new Shop();
        try {
            shop = shopService.addProductToShop(shopId, productId, productShop.getQuantity());
        } catch (IOException e) {
            System.out.println(e);
        }
        return shop;
    }

    public List<ProductShopDTO> getProductsInShop(Long shopId) {
        List<ProductShopDTO> productsInShop = new ArrayList<>();
        try {
            productsInShop = shopService.getProductsInShop(shopId);
        } catch (IOException e) {
            System.out.println(e);
        }
        return productsInShop;
    }


}
