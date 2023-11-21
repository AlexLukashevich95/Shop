package com.lukashevich.shop.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static File getOrCreateFile(Class<?> tClass) throws IOException {
        File file = new File(tClass.getSimpleName()+"Data.json");
        file.createNewFile();
        return file;
    }
}