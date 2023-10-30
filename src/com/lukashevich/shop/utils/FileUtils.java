package com.lukashevich.shop.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileUtils {

    public static File getOrCreateFile(Class cclass) throws IOException {
        File file = new File(PropertiesUtil.getFileName(cclass));
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