package com.enricoruggieri.json_mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonHelper {

    public static <E> List<E> initTableObject(String jsonFilePath, Type tableClass) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(jsonFilePath));
        Type typeToken = TypeToken.getParameterized(ArrayList.class, tableClass).getType();
        return gson.fromJson(reader, typeToken);
    }
}
