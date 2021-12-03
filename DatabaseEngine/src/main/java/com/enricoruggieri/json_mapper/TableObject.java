package com.enricoruggieri.json_mapper;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.List;

public class TableObject <E> {

    private final String tableName;
    private final Type tableClass;
    private final String jsonFilePath;
    private final List<E> tableObjectList;

    public TableObject(String tableName, Type tableClass, String jsonFilePath) throws FileNotFoundException {
        this.tableName = tableName;
        this.tableClass = tableClass;
        this.jsonFilePath = jsonFilePath;
        this.tableObjectList = initTableObjectList();
    }

    private List<E> initTableObjectList () throws FileNotFoundException {
        return GsonHelper.initTableObject(jsonFilePath, tableClass);
    }

    public String getTableName() {
        return tableName;
    }

    public Type getTableClass() {
        return tableClass;
    }

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public List<E> getTableObjectList() {
        return tableObjectList;
    }
}

