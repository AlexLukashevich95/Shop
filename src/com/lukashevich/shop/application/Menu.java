package com.lukashevich.shop.application;

import com.google.gson.reflect.TypeToken;
import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Menu {
    private final ProductController productController;
    private final ShopController shopController;

    public Menu(ProductController productController, ShopController shopController) {
        this.productController = productController;
        this.shopController = shopController;
    }

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("Choose operation : 1-add shop, 2-add product, 3-show all shops, 4-show all products, 0-exit");
            try {
                switch (sc.nextInt()) {
                    case 0:
                        break loop;
                    case 1:
                        Shop shop = new Shop();
                        sc.nextLine();
                        System.out.println("Write shop name");
                        shop.setName(sc.nextLine());
                        System.out.println("Write shop address");
                        shop.setAddress(chooseAddress(sc.nextLong()));
                        Date date1 = new Date();
                        shop.setDateOfAdding(date1);
                        shopController.saveShop(shop);
                        break;
                    case 2:
                        Product product = new Product();
                        sc.nextLine();
                        System.out.println("Write product name");
                        product.setName(sc.nextLine());
                        System.out.println("Write product price");
                        try {
                            product.setPrice(sc.nextLong());
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect type of data. Please use numbers");
                            break;
                        }
                        System.out.println("Write product quantity");
                        try {
                            product.setQuantity(sc.nextLong());
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect type of data. Please use numbers");
                            break;
                        }
                        sc.nextLine();
                        System.out.println("Write product type");
                        product.setType(sc.nextLine());
                        productController.saveProduct(product);
                        break;
                    case 3:
                        shopController.getAllShops().forEach(this::printShop);
                        break;
                    case 4:
                        productController.getAllProducts().forEach(this::printProduct);
                        break;
                    default:
                        System.out.println("Please input proposed option");

                }
            }
            catch (InputMismatchException e){
                System.out.println("Please input numeric value");
            }
        }
    }

    private void printShop(Shop shop) {
        System.out.println("name: " + shop.getName() + " || address: " + shop.getAddress());
    }

    private void printProduct(Product product) {
        System.out.println("name: " + product.getName() + " || type: " + product.getType());
    }

    private Long chooseAddress(Long id){
        /*File file = FileUtils.getOrCreateFile( tClass);
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        String objectsJson = new String(Files.readAllBytes(Path.of(file.getPath())));

        Type type = TypeToken.getParameterized(List.class,tClass).getType();
        System.out.println(type.getTypeName());
        return gson.fromJson(objectsJson, type);*/
        return id;
    }
}
