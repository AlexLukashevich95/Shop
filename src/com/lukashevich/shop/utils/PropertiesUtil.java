package com.lukashevich.shop.utils;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    private static final String APPLICATION_PROPERTIES_FILE_PATH = "application.properties";

    private static final Map<Class, String> classToFileNameMap = new HashMap<>() {{
        put(Shop.class, "db.file.name.shop");
        put(Product.class, "db.file.name.product");
    }};

    public static String getFileName(Class aclass) throws IOException {
        Properties properties = new Properties();
        try (InputStream fileInputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE_PATH)) {
            properties.load(fileInputStream);
            return properties.getProperty(classToFileNameMap.get(aclass));
        }
    }
}
