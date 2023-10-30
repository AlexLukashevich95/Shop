package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.AbstractFileRepository;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShopRepositoryImpl extends AbstractFileRepository<Shop> implements ShopRepository {

    protected ShopRepositoryImpl(Class<Shop> shopClass) {
        super(shopClass);
    }

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        return super.saveModel(shop);
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        return super.getAllModels();
    }

}
