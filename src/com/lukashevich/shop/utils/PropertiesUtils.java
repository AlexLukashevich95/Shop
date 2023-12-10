package com.lukashevich.shop.utils;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertiesUtils {

    private static final String APPLICATION_PROPERTIES_FILE_PATH = "application.properties";

    private final static Map<Class, String> classToFileNameMap = new HashMap<>() {{
        put(Shop.class, "db.file.name.shop");
        put(Product.class, "db.file.name.product");
    }};

    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();

        try (InputStream input = PropertiesUtils.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE_PATH)) {
            properties.load(input);
        }
        return properties.getProperty(key);
    }

    public static String getFileName(Class aclass) throws IOException {
        return getProperty(classToFileNameMap.get(aclass));
    }
}
