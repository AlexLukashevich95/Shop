package com.lukashevich.shop.service.impl;

import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository){
        this.shopRepository=shopRepository;
    }

    @Override
    public Shop saveShop(Shop shop) {
        return shopRepository.saveShop(shop);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.getAllShops();
    }

}
