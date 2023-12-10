package com.lukashevich.shop.repository.impl;

import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ShopRepositoryImpl extends BaseRepository<Shop> implements ShopRepository {

    public ShopRepositoryImpl() {
    }

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        return super.save(shop);
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        return super.getAll();
    }

    @Override
    public Shop getShopById(Long id) {
        return null;
    }

    @Override
    public Shop addProductToShop(ProductShop productShop, Shop shop) throws IOException {
        return null;
    }

    @Override
    public List<ProductShop> getProductInShop(Shop shop) throws IOException {
        return null;
    }

}
