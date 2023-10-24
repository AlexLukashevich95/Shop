package com.lukashevich.shop.application;

import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    ProductController productController;
    ShopController shopController;

    public Menu(ProductController productController, ShopController shopController) {
        this.productController = productController;
        this.shopController = shopController;
    }

    public void runMenu() throws IOException {
        boolean loop=true;
        Scanner sc = new Scanner(System.in);

        while (loop) {
            System.out.println("Choose operation : 1-add shop, 2-add product, 3-show all shops, 4-show all products, 0-exit");
            switch (sc.nextInt()) {
                case 0:
                    loop = false;
                    break;
                case 1:
                    Shop shop = new Shop();
                    sc.nextLine();
                    System.out.println("Write shop name");
                    shop.setName(sc.nextLine());
                    System.out.println("Write shop address");
                    shop.setAddress(sc.nextLine());
                    shop.setProducts(null);
                    shopController.saveShop(shop);
                    break;
                case 2:
                    Product product = new Product();
                    sc.nextLine();
                    System.out.println("Write product name");
                    product.setName(sc.nextLine());
                    System.out.println("Write product price");
                    product.setPrice(sc.nextLong());
                    System.out.println("Write product quantity");
                    product.setQuantity(sc.nextLong());
                    sc.nextLine();
                    System.out.println("Write product type");
                    product.setType(sc.nextLine());
                    Date date = new Date();
                    product.setDateOfAdding(date);
                    productController.saveProduct(product);
                    break;
                case 3:
                    shopController.getAllShops().forEach(System.out::println);
                    break;
                case 4:
                    productController.getAllProducts().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Please input proposed option");
            }
        }
    }
}
