package com.lukashevich.shop.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static File getOrCreateFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error with creating file");
            e.printStackTrace();
        }
        return file;
    }
}