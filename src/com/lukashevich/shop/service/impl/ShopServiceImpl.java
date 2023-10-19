package com.lukashevich.shop.service.impl;

import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.repository.impl.ShopRepositoryImpl;
import com.lukashevich.shop.service.ShopService;

public class ShopServiceImpl implements ShopService {
    ShopRepositoryImpl shopRepository = new ShopRepositoryImpl();

    @Override
    public Shop saveShop(Shop shop) {return shopRepository.saveShop(shop);}

    @Override
    public Shop getShopById(String id) {
        return shopRepository.getShopById(id);
    }
}
