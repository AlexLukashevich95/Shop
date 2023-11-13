package com.lukashevich.shop.application;


import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.repository.impl.ProductRepository;
import com.lukashevich.shop.repository.impl.ShopRepository;
import com.lukashevich.shop.service.ProductService;
import com.lukashevich.shop.service.ShopService;
import com.lukashevich.shop.service.impl.ProductServiceImpl;
import com.lukashevich.shop.service.impl.ShopServiceImpl;

public class Main {
    public static void main(String[] args){
        com.lukashevich.shop.repository.ShopRepository shopRepository = new ShopRepository();
        ShopService shopService = new ShopServiceImpl(shopRepository);
        ShopController shopController = new ShopController(shopService);

        com.lukashevich.shop.repository.ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductController productController = new ProductController(productService);

        Menu menu = new Menu(productController, shopController);
        menu.runMenu();
    }

}