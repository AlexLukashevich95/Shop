package com.lukashevich.shop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lukashevich.shop.model.BaseModel;
import com.lukashevich.shop.utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AbstractRepositoryImpl <T extends BaseModel>{
    private final Gson gson;
    private final Class<?> tClass;

    public AbstractRepositoryImpl() {
        this.gson = new GsonBuilder().create();
        this.tClass = (Class<?>)((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];;
    }

    public String getClassName(){
        return this.tClass.getName();
    }

    public T save(T object) throws IOException {
        String objectType = getClassName();
        System.out.println(objectType);
        File file = FileUtils.getOrCreateFile(getClassName()+"Data.json");
        List<T> objects = getAll();
        object.setId((long) objects.size() + 1);
        objects.add(object);
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(objects));
            writer.flush();
        }
        return object;
    }

    public List<T> getAll() throws IOException {
        String objectType = getClassName();
        System.out.println(objectType);
        File file = FileUtils.getOrCreateFile(getClassName()+"Data.json");
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        String objectsJson = new String(Files.readAllBytes(Path.of(file.getPath())));
        Type type = new TypeToken<ArrayList<T>>() {
        }.getType();
        return gson.fromJson(objectsJson, type);
    }
}
