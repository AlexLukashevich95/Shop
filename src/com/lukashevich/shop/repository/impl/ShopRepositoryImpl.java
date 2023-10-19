package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.utils.FileUtils;

import java.util.Arrays;
import java.util.List;

public class ShopRepositoryImpl implements ShopRepository {
    Gson gson;
    FileUtils fileUtils;

    public ShopRepositoryImpl() {
        this.gson= new GsonBuilder().create();
        this.fileUtils = new FileUtils();
    }

    @Override
    public Shop saveShop(Shop shop) {
        fileUtils.writeData("ShopData.txt",
                gson.toJson(shop));
        return null;
    }

    @Override
    public Shop getShopById(String id) {

        List<Shop> shops = Arrays.asList(gson.fromJson(fileUtils.readData("ShopData.txt"), Shop.class));
        for (Shop s : shops){
            System.out.println(s.getName());
        }
//        ArrayList<Shop> shops = new ArrayList<>();
//
//        shops=gson.fromJson();
//        fileUtils.readData("ShopData.txt");
        return null;
    }
}
