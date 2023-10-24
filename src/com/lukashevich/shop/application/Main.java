package com.lukashevich.shop.application;


import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ProductRepository;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.repository.impl.ProductRepositoryImpl;
import com.lukashevich.shop.repository.impl.ShopRepositoryImpl;
import com.lukashevich.shop.service.ProductService;
import com.lukashevich.shop.service.ShopService;
import com.lukashevich.shop.service.impl.ProductServiceImpl;
import com.lukashevich.shop.service.impl.ShopServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ShopRepository shopRepository = new ShopRepositoryImpl();
        ShopService shopService = new ShopServiceImpl(shopRepository);
        ShopController shopController = new ShopController(shopService);

        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductController productController = new ProductController(productService);

        Menu menu = new Menu(productController,shopController);
        menu.runMenu();
    }

}