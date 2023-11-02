package com.lukashevich.shop.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static File getOrCreateFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        return file;
    }
}