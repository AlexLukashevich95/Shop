package com.lukashevich.shop.repository;

import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.List;

public interface ShopRepository {
    Shop saveShop(Shop shop) throws IOException;

    List<Shop> getAllShops() throws IOException;

    Shop getShopById(Long id) throws IOException;

    Shop addProductToShop(Shop shop) throws IOException;

    List<ProductShop> getProductsInShop(Shop shop);
}
