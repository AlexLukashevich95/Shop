package com.lukashevich.shop.service.impl;

import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.service.ShopService;

import java.io.IOException;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        return shopRepository.saveShop(shop);
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        return shopRepository.getAllShops();
    }

    @Override
    public Shop getShopById(Long id) throws IOException {
        return shopRepository.getShopById(id);
    }

    @Override
    public Shop addProductToShop(Shop shop) throws IOException {
        return shopRepository.addProductToShop(shop);
    }

    @Override
    public List<ProductShop> getProductsInShop(Shop shop) {
        return shopRepository.getProductsInShop(shop);
    }

}
