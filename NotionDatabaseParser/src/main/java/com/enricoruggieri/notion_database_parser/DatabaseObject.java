package com.enricoruggieri.notion_database_parser;

import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class DatabaseObject {

    private final NotionClient client;
    private final RecordParser recordParser;
    private final List<Page> databasePages;


    public DatabaseObject(NotionClient client, RecordParser recordParser) {
        this.client = client;
        this.recordParser = recordParser;
        this.databasePages = recordParser.getDatabasePages();
    }

    public List<RecordFields> buildDatabase() {
        return new ArrayList<>();
    }

    public RecordParser getRecordParser() {
        return recordParser;
    }

    public List<Page> getDatabasePages() {
        return databasePages;
    }
}
