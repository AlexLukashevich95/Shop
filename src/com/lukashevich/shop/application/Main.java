package com.lukashevich.shop.application;

import com.google.gson.Gson;
import com.lukashevich.shop.FileProccess;
import com.lukashevich.shop.model.Shop;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Shop");
        FileProccess fileProccess = new FileProccess();
        Gson gson= new Gson();
        Shop shop = new Shop(1L,"Prodtovary","Masherova 53 str.", null);
        fileProccess.writeData("ShopData.txt",
                gson.toJson(shop));
        System.out.println(fileProccess.readData("ShopData.txt"));
    }
}