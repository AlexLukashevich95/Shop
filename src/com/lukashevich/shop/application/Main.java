package com.lukashevich.shop.application;

import com.lukashevich.shop.controller.ProductController;
import com.lukashevich.shop.controller.ShopController;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.utils.FileUtils;
import com.lukashevich.shop.model.Shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ShopController shopController = new ShopController();
        ProductController ProductController = new ProductController();
        FileUtils fileUtils = new FileUtils();
        Long idShop=1L, idProduct=1L;
        boolean loop=true;
        while (loop){
            int action;
            System.out.println("Choose action: 1-add shop, 2-add product, 3-get all shops, 4-get all products, 0-Exit");
            Scanner sc = new Scanner(System.in);
            action=sc.nextInt();
            switch (action) {
                case 1:
                    String nameShop,address;
                    //ArrayList<Product> products = new ArrayList<>();
                    System.out.println("Write shop name:");
                    nameShop = sc.nextLine();
                    System.out.println("Write shop address:");
                    address = sc.nextLine();
                    //System.out.println("choose shop products:");
                    Shop shop = new Shop(idShop,nameShop,address,null);
                    shopController.saveShop(shop);
                    idShop++;
                    break;
                case 2:
                    String nameProduct,type;
                    Long price ,quantity;
                    Date dateOfAdding ;
                    System.out.println("Write product name:");
                    nameProduct = sc.nextLine();
                    System.out.println("Write product price:");
                    price = sc.nextLong();
                    System.out.println("Write product quantity:");
                    quantity = sc.nextLong();
                    System.out.println("Write product type:");
                    type = sc.nextLine();
                    Date date = new Date();
                    dateOfAdding = date;
                    Product product = new Product(idProduct,nameProduct,price,quantity,type,dateOfAdding);
                    ProductController.saveProduct(product);
                    idProduct++;
                    break;
                case 3:
                    System.out.println(fileUtils.readData("ShopData.txt"));
                    break;
                case 4:
                    System.out.println(fileUtils.readData("ProductData.txt"));
                    break;
                case 0:
                    loop=false;
                    break;
                default:
                    break;
            }
        }
    }
}