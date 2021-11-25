package com.enricoruggieri.json_to_gspreadsheet;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TableObject <E> {
    private final String tableName;
    private final Type tableClass;
    private final Integer dimensionIndex;
    private final String inputFile;
    private final List<E> tableObject;
    private final List<List<Object>> valuesList;

    public TableObject(String tableName, Type tableClass, Integer dimensionIndex) throws FileNotFoundException {
        this.tableName = tableName;
        this.tableClass = tableClass;
        this.dimensionIndex = dimensionIndex;
        this.inputFile = "json/" + tableName + ".json";
        this.tableObject = initTableObject();
        this.valuesList = initValuesList();
    }

    public abstract List<List<Object>> initValuesList();

    protected abstract List<E> initTableObject() throws FileNotFoundException;

    public String getTableName() {
        return tableName;
    }

    public List<E> getTableObject() {
        return tableObject;
    }

    public List<List<Object>> getValuesList() {
        return valuesList;
    }

    public String getInputFile() {
        return this.inputFile;
    }

    public Type getTableClass() {
        return tableClass;
    }

    public Integer getDimensionIndex() {
        return dimensionIndex;
    }
}
