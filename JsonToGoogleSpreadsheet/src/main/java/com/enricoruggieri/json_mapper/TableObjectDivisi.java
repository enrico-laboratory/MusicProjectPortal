package com.enricoruggieri.json_mapper;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;

public class TableObjectDivisi extends TableObject<TableMapDivisi> {

    public TableObjectDivisi() throws FileNotFoundException {
        super(Config.TABLE_NAME_DIVISI, TableMapDivisi.class, Config.JSON_DIVISI);
    }
}
