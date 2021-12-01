package com.enricoruggieri.to_gsheet;

import com.enricoruggieri.notion_client.NotionWrapper;
import notion.api.v1.model.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MasterTables tables = new MasterTables();

        var repertoire = tables.getTableRepertoireAndDivisi();
        var schedule = tables.getTableSchedules();
        var cast = tables.getTableCast();
        var location = tables.getTableLocation();
        System.out.println("hello!");

        // Build a value list compatible with gSheet

    }
}
