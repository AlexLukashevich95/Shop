package com.lukashevich.shop.application;

import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Address;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

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
            switch (sc.nextInt()) {
                case 0:
                    break loop;
                case 1:
                    Shop shop = new Shop();
                    sc.nextLine();
                    System.out.println("Write shop name");
                    shop.setName(sc.nextLine());
                    System.out.println("Write shop address");
                    shop.setAddress(new Address(1L, new Date(), "city1", "street1", 1, 1));
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
                        System.out.println(e);
                        break loop;
                    }
                    System.out.println("Write product quantity");
                    try {
                        product.setQuantity(sc.nextLong());
                    } catch (InputMismatchException e) {
                        System.out.println(e);
                        break loop;
                    }
                    sc.nextLine();
                    System.out.println("Write product type");
                    product.setType(sc.nextLine());
                    Date date = new Date();
                    product.setDateOfAdding(date);
                    productController.saveProduct(product);
                    break;
                case 3:
                    shopController.getAllShops().forEach(this::writeShop);
                    break;
                case 4:
                    productController.getAllProducts().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Please input proposed option");
            }
        }
    }

    private void writeShop(Shop shop) {
        System.out.println(shop.getId());
        System.out.println(shop.getName());
        writeAddress(shop.getAddress());
        System.out.println(shop.getDateOfAdding());

    }
    private void writeAddress(Address address) {
        System.out.println(address.getCity());
        System.out.println(address.getStreet());
        System.out.println(address.getHouseNumber());
        System.out.println(address.getApartmentNumber());
    }
}
