package com.lukashevich.shop.utils;

import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.Shop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertiesUtils {
    private static Properties properties;

    private static final String APPLICATION_PROPERTIES_FILE_PATH = "application.properties";

    private final static Map<Class, String> classToFileNameMap = new HashMap<>() {{
        put(Shop.class, "db.file.name.shop");
        put(Product.class, "db.file.name.product");
    }};

    static {
        properties = new Properties();

        try (InputStream input = PropertiesUtils.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE_PATH)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex){
            System.out.println("File not found: " + APPLICATION_PROPERTIES_FILE_PATH);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getFileName(Class aclass) {
        return properties.getProperty(classToFileNameMap.get(aclass));
    }
}
