package com.enricoruggieri.json_mapper;

import java.io.FileNotFoundException;

public class TableObjectRepertoire extends TableObject<TableMapRepertoire> {

    public TableObjectRepertoire() throws FileNotFoundException {
        super(Config.TABLE_NAME_REPERTOIRE, TableMapRepertoire.class, Config.JSON_REPERTOIRE);
    }
}
