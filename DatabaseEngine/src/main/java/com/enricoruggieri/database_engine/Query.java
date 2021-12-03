package com.enricoruggieri.database_engine;

import notion.api.v1.NotionClient;
import notion.api.v1.model.databases.query.filter.CompoundFilter;
import notion.api.v1.model.databases.query.filter.PropertyFilter;
import notion.api.v1.model.databases.query.filter.condition.SelectFilter;
import notion.api.v1.model.pages.Page;
import notion.api.v1.request.databases.QueryDatabaseRequest;

import java.util.ArrayList;
import java.util.List;

public class Query {

    private final NotionClient client;

    public Query() {
        if (System.getenv("NOTION_TOKEN").isEmpty()) {
            System.out.println("Token not found!");
        }
        String token = System.getenv("NOTION_TOKEN");
        this.client = new NotionClient(token);
    }

    public List<Page> getMusicProjectTable () {
        return getTable(Config.MUSIC_PROJECT_TABLE_ID);
    }

    public List<Page> getRepertoireandDivisiTable () {
        return getTable(Config.REPERTOIRE_AND_DIVISI_TABLE_ID);
    }

    public List<Page> getScheduleTable () {
        List<PropertyFilter> filtersList = new ArrayList<>();
        filtersList.add(new PropertyFilter("Type",null, null, null, null, null, null, null,
                new SelectFilter("Rehearsal")));
        filtersList.add(new PropertyFilter("Type",null, null, null, null, null, null, null,
                new SelectFilter("Concert")));
        CompoundFilter filter = new CompoundFilter(filtersList);
        return client.queryDatabase(new QueryDatabaseRequest(Config.SCHEDULE_TABLE_ID, filter)).getResults();
    }

    public List<Page> getCastTable () {
        return getTable(Config.CAST_DATABASE);
    }

    public List<Page> getLocationTable () {
        return getTable(Config.LOCATION_TABLE_ID);
    }

    private List<Page> getTable(String tableId) {
        return client.queryDatabase(new QueryDatabaseRequest(tableId)).getResults();
    }
}
