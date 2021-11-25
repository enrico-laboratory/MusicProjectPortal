package com.enricoruggieri.notion_database_parser;

import notion.api.v1.NotionClient;
import notion.api.v1.model.databases.DatabaseProperty;
import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageProperty;
import notion.api.v1.request.databases.QueryDatabaseRequest;

import java.util.ArrayList;
import java.util.List;

public class RecordParser {

    private final NotionClient client;
    private final String databaseId;
    private final List<Page> databasePages;

    public RecordParser(NotionClient client, String databaseId) {
        this.client = client;
        this.databaseId = databaseId;
        databasePages = client.queryDatabase(new QueryDatabaseRequest(databaseId)).getResults();
    }

    public String getTitleValue(Page page, String field) {
        if (getField(page, field).getTitle().isEmpty() ) {
            return "";
        } else {
            return getField(page, field).getTitle().get(0).getPlainText();
        }
    }

    public String getTitleValueRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return "";
        } else if (getRollup(page, field).isEmpty()) {
            return "";
        } else {
            return getRollup(page, field).get(0).getTitle().get(0).getPlainText();
        }
    }

    public String getRichText(Page page, String field) {
        if (getField(page, field) == null) {
            return "";
        } else if (getField(page, field).getRichText().isEmpty() ) {
            return "";
        } else {
            return getField(page, field).getRichText().get(0).getPlainText();
        }
    }

    public String getRichTextRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return "";
        } else if (getRollup(page, field).isEmpty() || getRollup(page, field).get(0).getRichText().isEmpty() ) {
            return "";
        } else {
            return getRollup(page, field).get(0).getRichText().get(0).getPlainText();
        }
    }

    public Number getNumberRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return null;
        } else if (getRollup(page, field).isEmpty() ) {
            return null;
        } else {
            return getRollup(page, field).get(0).getNumber();
        }
    }

    public String getLinkRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return "";
        } else if (getRollup(page, field).isEmpty() ) {
            return "";
        } else {
            return getRollup(page, field).get(0).getUrl();
        }
    }

    public String getSelectRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return "";
        } else if (getRollup(page, field).isEmpty()) {
            return "";
        } else if (getRollup(page, field).get(0).getSelect() == null) {
            return  "";
        } else if (getRollup(page, field).get(0).getSelect().getName() == null) {
            return "";
        } else {
            return getRollup(page, field).get(0).getSelect().getName();
        }
    }

    public Number getFormula(Page page, String field) {
        if (getField(page, field) == null) {
            return null;
        } else if (getField(page, field).getFormula().getNumber() == null) {
            return null;
        } else {
            return getField(page, field).getFormula().getNumber();
        }
    }

    public Boolean getCheckbox(Page page, String field) {
        if (getField(page, field) == null) {
            return null;
        } else {
            return getField(page, field).getCheckbox();
        }
    }

    public List<String> getMultiSelectRollupValue(Page page, String field) {

        List<String> multiSelectNames = new ArrayList<>();

        if (getRollup(page, field) == null) {
            return multiSelectNames;
        } else if (getRollup(page, field).isEmpty()) {
            return multiSelectNames;
        } else if (getRollup(page, field).get(0).getMultiSelect() == null){
            return multiSelectNames;
        }

        List<DatabaseProperty.MultiSelect.Option> multiSelectRollup = getRollup(page, field).get(0).getMultiSelect();
        multiSelectRollup.forEach(multiSelectName -> multiSelectNames.add(multiSelectName.getName()));
        return multiSelectNames;
    }

    public List<String> getRelationsValue(Page page, String field) {

        List<PageProperty.PageReference> relations = getField(page, field).getRelation();
        List<String> relationIds = new ArrayList<>();

        if (relations == null) {
            return relationIds;
        }

        for (PageProperty.PageReference relation : relations) {
            relationIds.add(relation.getId());
        }
        return relationIds;
    }

    private List<PageProperty> getRollup(Page page, String field) {
        try {
            getField(page, field).getRollup();
        } catch (NullPointerException e){
            return null;
        }
        if (getField(page, field).getRollup().getArray() == null) {
            return null;
        }
        return getField(page, field).getRollup().getArray();
    }

    private PageProperty getField(Page page, String field) {
        return page.getProperties().get(field);
    }

    public List<Page> getDatabasePages() {
        return databasePages;
    }
    }
