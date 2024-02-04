package com.lukashevich.shop.service;

import com.lukashevich.shop.dto.ProductShopDTO;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.List;

public interface ShopService {
    Shop saveShop(Shop shop) throws IOException;

    List<Shop> getAllShops() throws IOException;

    Shop getShopById(Long id) throws IOException;

    Shop addProductToShop(Long shopId, Long productId, Integer quantity) throws IOException;

    List<ProductShopDTO> getProductsInShop(Long shopId) throws IOException;
}
