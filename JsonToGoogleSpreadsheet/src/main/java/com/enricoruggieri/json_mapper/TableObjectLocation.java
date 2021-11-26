package com.enricoruggieri.json_mapper;

import java.io.FileNotFoundException;

public class TableObjectLocation extends TableObject<TableMapLocation> {

    public TableObjectLocation() throws FileNotFoundException {
        super(Config.TABLE_NAME_LOCATION, TableMapLocation.class, Config.JSON_LOCATION);
    }
}
