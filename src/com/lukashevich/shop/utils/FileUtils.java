package com.lukashevich.shop.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public File getOrCreateFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }
        return file;
    }
}