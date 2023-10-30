package com.lukashevich.shop.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lukashevich.shop.model.BaseModel;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.ParameterizedType;


public abstract class AbstractFileRepository<T extends BaseModel> {
    private final Gson gson;
    private final ParameterizedType tClass;

    protected AbstractFileRepository(Class<T> tClass) {
        this.gson = new GsonBuilder().create();
        this.tClass =  (ParameterizedType) getClass().getGenericSuperclass();
    }

    protected T saveModel(T model) throws IOException {
        List<T> models = getAllModels();
        model.setId((long) models.size() + 1);
        models.add(model);
        FileWriter writer = new FileWriter(FileUtils.getOrCreateFile(tClass.getClass()), false);
        writer.write(gson.toJson(models));
        writer.flush();
        writer.close();
        return model;
    }

    protected List<T> getAllModels() throws IOException {
        File file = FileUtils.getOrCreateFile(tClass.getClass());
        if (file.length() == 0) {
            return new ArrayList<>();
        } else {
            String shopsJson = new String(Files.readAllBytes(Path.of(file.getPath())));
            Type type = TypeToken.getParameterized(List.class, tClass.getClass()).getType();
            return gson.fromJson(shopsJson, type);
        }
    }
}