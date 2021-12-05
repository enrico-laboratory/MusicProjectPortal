package com.enricoruggieri.json_mapper;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;

public class TableObjectCast extends TableObject<TableMapCast> {

    public TableObjectCast() throws FileNotFoundException {
        super(Config.TABLE_NAME_CAST, TableMapCast.class, Config.JSON_CAST);
    }
}
