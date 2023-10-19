package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.utils.FileUtils;

public class ShopRepositoryImpl implements ShopRepository {

    @Override
    public Shop saveShop(Shop shop) {
        Gson gson= new Gson();
        FileUtils fileUtils =new FileUtils();
        fileUtils.writeData("ShopData.txt",
                gson.toJson(shop));
        return shop;
    }

    @Override
    public Shop getShopById(String id) {
        return null;
    }
}
