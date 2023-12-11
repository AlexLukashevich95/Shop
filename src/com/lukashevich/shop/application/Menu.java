package com.lukashevich.shop.application;

import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Address;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.utils.PropertiesUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
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
            System.out.println("Choose operation : 1-add shop, 2-add product, 3-add products to shop, 4-show all shops, 5-show all products, 6-show all products in shop, 0-exit");
            try {
                switch (sc.nextInt()) {
                    case 0:
                        break loop;
                    case 1:
                        Shop shop = new Shop();
                        sc.nextLine();
                        System.out.println("Write shop name");
                        shop.setName(sc.nextLine());
                        shop.setAddress(setAddress());
                        shopController.saveShop(shop);
                        break;
                    case 2:
                        Product product = new Product();
                        sc.nextLine();
                        System.out.println("Write product name");
                        product.setName(sc.nextLine());
                        System.out.println("Write product type");
                        product.setType(sc.nextLine());
                        System.out.println("Write product price");
                        product.setPrice(inputNumberLong());
                        productController.saveProduct(product);
                        break;
                    case 3:
                        shopController.getAllShops().forEach(this::printShop);
                        System.out.println("Choose shop by id");
                        Shop shop1 = shopController.getShopById(inputNumberLong());
                        addProductsToShop(shop1);
                        break;
                    case 4:
                        shopController.getAllShops().forEach(this::printShop);
                        break;
                    case 5:
                        productController.getAllProducts().forEach(this::printProduct);
                        break;
                    case 6:
                        shopController.getAllShops().forEach(this::printShop);
                        System.out.println("Please choose which shop products you want to see");
                        Shop shop2 = shopController.getShopById(inputNumberLong());
                        shopController.getProductsInShop(shop2).forEach(this::printProductsInShop);
                        break;
                    default:
                        System.out.println("Please input proposed option");

                }
            } catch (InputMismatchException e) {
                System.out.println("Please input numeric value");
            }
        }
    }

    private void printShop(Shop shop) {
        System.out.println("name: " + shop.getName() + " || address: " + shop.getAddress().getCity() + ", " + shop.getAddress().getStreet() + " str." + " || Date of adding: " + getDateInSpecFormat(shop.getDateOfAdding()));
    }

    private void printProduct(Product product) {
        System.out.println("name: " + product.getName() + " || type: " + product.getType() + "|| price: " + product.getPrice() + " || Date of adding: " + getDateInSpecFormat(product.getDateOfAdding()));
    }

    private void printProductsInShop(ProductShop productShop) {
        Product product = productController.getProductById(productShop.getIdProduct());
        System.out.println("name: " + product.getName() + " || type: " + product.getType() + "|| price: " + product.getPrice() + "|| quantity: " + productShop.getQuantity());
    }

    private Address setAddress() {
        Scanner sc = new Scanner(System.in);
        Address address = new Address();
        System.out.println("Write shop city");
        address.setCity(sc.nextLine());
        System.out.println("Write shop street");
        address.setStreet(sc.nextLine());
        return address;
    }

    public Shop addProductsToShop(Shop shop) {
        List<Product> productList = productController.getAllProducts();
        List<ProductShop> productShopList = shop.getProducts();
        Scanner input = new Scanner(System.in);
        loopProducts:
        while (true) {
            System.out.println("Choose operation : 1-add product, 0-exit");
            switch (input.nextInt()) {
                case 0:
                    break loopProducts;
                case 1:
                    if (productList.size() > 0) {
                        productList.forEach(this::printProduct);
                        System.out.println("Choose product by id");
                        Long id = inputNumberLong();
                        ProductShop productShop = new ProductShop();
                        productShop.setIdShop(shop.getId());
                        productShop.setIdProduct(id);
                        System.out.println("Write product quantity");
                        productShop.setQuantity(inputNumberLong());
                        productShopList.add(productShop);
                    } else {
                        System.out.println("There is no products in database");
                        break loopProducts;
                    }
                    break;
            }
            shop.setProducts(productShopList);
            shopController.addProductToShop(shop);
        }
        return shop;
    }

    private Long inputNumberLong() {
        long result;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                result = input.nextLong();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Incorrect type of data. Please use numbers");
            }
        }
        return result;
    }

    private int inputNumber() {
        int result;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                result = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Incorrect type of data. Please use numbers");
            }
        }
        return result;
    }

    private String getDateInSpecFormat(Date dateOfAdding) {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        try {
            dateFormat = new SimpleDateFormat(PropertiesUtils.getProperty("date.format"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dateFormat.format(dateOfAdding);
    }

}
