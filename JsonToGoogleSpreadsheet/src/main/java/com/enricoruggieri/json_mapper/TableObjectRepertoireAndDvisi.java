package com.enricoruggieri.json_mapper;

import java.io.FileNotFoundException;

public class TableObjectRepertoireAndDvisi extends TableObject<TableMapRepertoireAndDivisi> {

    public TableObjectRepertoireAndDvisi() throws FileNotFoundException {
        super(Config.TABLE_NAME_REPERTOIRE, TableMapRepertoireAndDivisi.class, Config.JSON_REPERTOIRE);
    }
}
