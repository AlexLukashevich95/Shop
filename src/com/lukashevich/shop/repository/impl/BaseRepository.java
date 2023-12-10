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
import java.util.Date;
import java.util.List;

public abstract class BaseRepository<T extends BaseModel> {
    private final Gson gson;
    private final Class<?> tClass;

    public BaseRepository() {
        this.gson = new GsonBuilder().create();
        this.tClass = (Class<?>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        ;
    }

    public T save(T object) throws IOException {
        File file = FileUtils.getOrCreateFile(tClass);
        List<T> objects = getAll();
        object.setId(getNextId(objects));
        Date date = new Date();
        object.setDateOfAdding(date);
        objects.add(object);
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(objects));
            writer.flush();
        }
        return object;
    }

    public List<T> getAll() throws IOException {
        File file = FileUtils.getOrCreateFile(tClass);
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        String objectsJson = new String(Files.readAllBytes(Path.of(file.getPath())));

        Type type = TypeToken.getParameterized(List.class, tClass).getType();
        return gson.fromJson(objectsJson, type);
    }

    public T getById(Long id) throws IOException {
        List<T> objects = getAll();
        T object = null;  //не особо понимаю , как правильно инициализировать. new Object и new T не подходят
        for (T element : objects) {
            if (element.getId().equals(id)) {
                object = element;
                break;
            }
        }
        return object;
    }

    private Long getNextId(List<T> objects) {
        Long maxId = 0L;

        for (BaseModel object : objects) {
            if (object.getId() > maxId) {
                maxId = object.getId();
            }
        }
        return maxId + 1;
    }
}
