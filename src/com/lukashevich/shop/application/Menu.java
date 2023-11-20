package com.lukashevich.shop.application;

import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Address;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.service.ProductService;
import com.lukashevich.shop.service.ShopService;
import com.lukashevich.shop.utils.PropertiesUtils;

import java.text.SimpleDateFormat;
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
                        shop.setAddress(setAddress());
                        shopController.saveShop(shop);
                        break;
                    case 2:
                        Product product = new Product();
                        sc.nextLine();
                        System.out.println("Write product name");
                        product.setName(sc.nextLine());
                        System.out.println("Write product price");
                        product.setPrice(inputNumber());
                        System.out.println("Write product quantity");
                        product.setQuantity(inputNumber());
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
            } catch (InputMismatchException e) {
                System.out.println("Please input numeric value");
            } catch (NullPointerException e) {
                System.out.println("Please check"); // мне кажется это неправильным
                break;
            }
        }
    }

    private void printShop(Shop shop) {
        System.out.println("name: " + shop.getName() + " || address: " + shop.getAddress().getCity() + ", " + shop.getAddress().getStreet() + " str." + " || Date of adding: " + getDateInSpecFormat(shop.getDateOfAdding()));
    }

    private void printProduct(Product product) {
        System.out.println("name: " + product.getName() + " || type: " + product.getType() + " || Date of adding: " + getDateInSpecFormat(product.getDateOfAdding()));
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
    private Long inputNumber(){
        long result;
        Scanner input = new Scanner(System.in);
        while (true){
            try {
                result= input.nextLong();
                input.nextLine();
                break;
            }
            catch(InputMismatchException e){
                input.nextLine();
                System.out.println("Incorrect type of data. Please use numbers");
            }
        }
        return result;
    }

    private String getDateInSpecFormat(Date dateOfAdding) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PropertiesUtils.getProperty("date.format"));
        return dateFormat.format(dateOfAdding);
    }

}
