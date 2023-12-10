package com.lukashevich.shop.service;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.List;

public interface ShopService {
    Shop saveShop(Shop shop) throws IOException;

    List<Shop> getAllShops() throws IOException;

    Shop getShopById(Long id);

    Shop addProductToShop(ProductShop productShop, Shop shop) throws IOException;

    List<ProductShop> getProductsInShop(Shop shop) throws IOException;
}
