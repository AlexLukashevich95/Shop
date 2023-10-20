package com.lukashevich.shop.application;


import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.repository.impl.ShopRepositoryImpl;
import com.lukashevich.shop.service.ShopService;
import com.lukashevich.shop.service.impl.ShopServiceImpl;

public class Main {
    public static void main(String[] args) {
        ShopRepository shopRepository = new ShopRepositoryImpl();
        ShopService shopService = new ShopServiceImpl(shopRepository);
        ShopController shopController = new ShopController(shopService);

        Shop shop = new Shop(1L,"Prodtovary","Masherova 53 str.", null);
        shopController.saveShop(shop);
        shop = new Shop(2L,"Korona","Moskovskaya 123 str.", null);
        shopController.saveShop(shop);
        shopController.getShopById("1");
    }
}