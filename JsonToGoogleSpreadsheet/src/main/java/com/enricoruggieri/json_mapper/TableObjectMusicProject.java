package com.enricoruggieri.json_mapper;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;

public class TableObjectMusicProject extends TableObject<TableMapMusicProjects> {

    public TableObjectMusicProject() throws FileNotFoundException {
        super(Config.TABLE_NAME_MUSIC_PROJECT, TableMapMusicProjects.class, Config.JSON_MUSIC_PROJECT);
    }
}
