package com.enricoruggieri.notion_wrapper;

import notion.api.v1.NotionClient;
import notion.api.v1.model.databases.DatabaseProperty;
import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageProperty;

import java.util.ArrayList;
import java.util.List;

public class NotionWrapper {

    public NotionWrapper(NotionClient client, String databaseId) {}

    public static String getTitleValue(Page page, String field) {
        if (getField(page, field) == null) {
            return "";
        } else if (getField(page, field).getTitle().isEmpty() ) {
            return "";
        } else {
            return getField(page, field).getTitle().get(0).getPlainText();
        }
    }

    public static List<String> getTitleValueRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return new ArrayList<>();
        } else if (getRollup(page, field).isEmpty()) {
            return new ArrayList<>();
        } else {
            List<String> list = new ArrayList<>();
            List<PageProperty> titlesList = getRollup(page, field);
            titlesList.forEach(title ->
                    list.add(title.getTitle().get(0).getPlainText()));
            return list;
        }
    }

    public static String getRichText(Page page, String field) {
        if (getField(page, field) == null) {
            return "";
        } else if (getField(page, field).getRichText().isEmpty() ) {
            return "";
        } else {
            return getField(page, field).getRichText().get(0).getPlainText();
        }
    }

    public static List<String> getRichTextRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return new ArrayList<>();
        } else if (getRollup(page, field).isEmpty() || getRollup(page, field).get(0).getRichText().isEmpty() ) {
            return new ArrayList<>();
        } else {
            List<String> list = new ArrayList<>();
            List<PageProperty> richTexts = getRollup(page, field);
            richTexts.forEach(richText ->
                    list.add(richText.getRichText().get(0).getPlainText()));
            return list;
        }
    }

    public static List<Number> getNumberRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return new ArrayList<>();
        } else if (getRollup(page, field).isEmpty() ) {
            return new ArrayList<>();
        } else {
            List<Number> list = new ArrayList<>();
            List<PageProperty> numbers = getRollup(page, field);
            numbers.forEach(number ->
                    list.add(number.getNumber()));
            return list;
        }
    }

    public static List<String> getLinkRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return new ArrayList<>();
        } else if (getRollup(page, field).isEmpty() ) {
            return new ArrayList<>();
        } else {
            List<String> list = new ArrayList<>();
            List<PageProperty> links = getRollup(page, field);
            links.forEach(link ->
                    list.add(link.getUrl()));
            return list;
        }
    }

    public static String getFormulaString(Page page, String field) {
        if (getField(page, field) == null) {
            return "";
        } else {
            return getField(page, field).getFormula().getString();
        }
    }

    public static List<String> getDate(Page page, String field) {
        if (getField(page, field) == null) {
            return getDateList("", "");
        } else if (getField(page, field).getDate() == null) {
            return getDateList("", "");
        } else {
            String start = getField(page, field).getDate().getStart();
            String end = getField(page, field).getDate().getEnd();
            return getDateList(start, end);
        }
    }
    private static List<String> getDateList(String start, String end) {
        List<String> date = new ArrayList<>();
        date.add(start);
        date.add(end);
        return date;
    }

    public static String getSelect(Page page, String field) {
        if (getField(page, field) == null) {
            return "";
        } else if (getField(page, field).getSelect() == null) {
            return "";
        } else if (getField(page, field).getSelect().getName() == null) {
            return "";
        } else {
            return getField(page, field).getSelect().getName();
        }
    }
    public static String getEmailRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return "";
        } else if (getRollup(page, field).isEmpty()) {
            return "";
        } else if (getRollup(page, field).get(0).getEmail().isEmpty()) {
            return "";
        } else {
            return getRollup(page, field).get(0).getEmail();
        }
    }

    public static String getPhoneRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return "";
        } else if (getRollup(page, field).isEmpty()) {
            return "";
        } else if (getRollup(page, field).get(0).getPhoneNumber() == null) {
            return "";
        } else {
            return getRollup(page, field).get(0).getPhoneNumber();
        }
    }

    public static List<String> getSelectRollup(Page page, String field) {
        if (getRollup(page, field) == null) {
            return new ArrayList<>();
        } else if (getRollup(page, field).isEmpty()) {
            return new ArrayList<>();
        } else if (getRollup(page, field).get(0).getSelect() == null) {
            return new ArrayList<>();
        } else if (getRollup(page, field).get(0).getSelect().getName() == null) {
            return new ArrayList<>();
        } else {
            List<String> list = new ArrayList<>();
            List<PageProperty> selects = getRollup(page, field);
            selects.forEach(select ->
                    list.add(select.getSelect().getName()));
            return list;
        }
    }

    public static Number getFormulaNumber(Page page, String field) {
        if (getField(page, field) == null) {
            return null;
        } else if (getField(page, field).getFormula().getNumber() == null) {
            return null;
        } else {
            return getField(page, field).getFormula().getNumber();
        }
    }

    public static Boolean getCheckbox(Page page, String field) {
        if (getField(page, field) == null) {
            return null;
        } else {
            return getField(page, field).getCheckbox();
        }
    }

    public static List<String> getMultiSelectRollupValue(Page page, String field) {

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

    public static List<String> getMultiSelectValue(Page page, String field) {

        List<String> multiSelectNames = new ArrayList<>();

        if (getField(page, field) == null) {
            return multiSelectNames;
        } else if (getField(page, field).getMultiSelect() == null){
            return multiSelectNames;
        } else if (getField(page, field).getMultiSelect().isEmpty()) {
            return multiSelectNames;
        }

        List<DatabaseProperty.MultiSelect.Option> multiSelectRollup = getField(page, field).getMultiSelect();
        multiSelectRollup.forEach(multiSelectName -> multiSelectNames.add(multiSelectName.getName()));
        return multiSelectNames;
    }

    public static String getId(Page page, String musicProjectTableId) {
        return page.getId();
    }

    public static List<String> getRelationsValue(Page page, String field) {
        if (getField(page, field) == null) {
            return new ArrayList<>();
        } else if (getField(page, field).getRelation() == null) {
            return new ArrayList<>();
        } else {
            List<PageProperty.PageReference> relations = getField(page, field).getRelation();
            List<String> relationIds = new ArrayList<>();
            for (PageProperty.PageReference relation : relations) {
                relationIds.add(relation.getId());
            }
            return relationIds;
        }
    }

    private static List<PageProperty> getRollup(Page page, String field) {
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

    private static PageProperty getField(Page page, String field) {
        try {
            page.getProperties().get(field);
        } catch (NullPointerException e ) {
            System.out.println(field + " not a valid field");
            e.printStackTrace();
        }
        return page.getProperties().get(field);
    }
}
