package com.enricoruggieri.notion_client;

import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapSchedule extends TableMapObject {

    private final String task;
    private final String type;
    private final String doDateStart;
    private final String doDateEnd;
    private final List<String> musicProject;
    private final List<String> locationRollup;
    private final String duration;
//    private final List<String> choirRollup;
    private final List<String> location;

    public TableMapSchedule(Page page) {
        super(page);
        this.task = NotionWrapper.getTitleValue(page, Config.SCHEDULE_TABLE_TASK);
        this.type = NotionWrapper.getSelect(page, Config.SCHEDULE_TABLE_TYPE);
        this.doDateStart = NotionWrapper.getDate(page, Config.SCHEDULE_TABLE_DO_DATE).get(0);
        this.doDateEnd = NotionWrapper.getDate(page, Config.SCHEDULE_TABLE_DO_DATE).get(1);
        this.musicProject = NotionWrapper.getRelationsValue(page, Config.SCHEDULE_TABLE_MUSIC_PROJECT);
        this.locationRollup = NotionWrapper.getTitleValueRollup(page, Config.SCHEDULE_TABLE_LOCATION_ROLLUP);
        this.duration = NotionWrapper.getFormulaString(page, Config.SCHEDULE_TABLE_DURATION);
//        this.choirRollup = NotionWrapper.getTitleValueRollup(page, Config.SCHEDULE_TABLE_CHOIR_ROLLUP);
        this.location = NotionWrapper.getRelationsValue(page, Config.SCHEDULE_TABLE_LOCATION);
    }

    public String getTask() {
        return task;
    }

    public String getType() {
        return type;
    }

    public String getDoDateStart() {
        return doDateStart;
    }

    public String getDoDateEnd() {
        return doDateEnd;
    }

    public List<String> getMusicProject() {
        return musicProject;
    }

    public List<String> getLocationRollup() {
        return locationRollup;
    }

    public String getDuration() {
        return duration;
    }

//    public List<String> getChoirRollup() {
//        return choirRollup;
//    }

    public List<String> getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "TableMapSchedule{" +
                "task='" + task + '\'' +
                ", type='" + type + '\'' +
                ", doDateStart='" + doDateStart + '\'' +
                ", doDateEnd='" + doDateEnd + '\'' +
                ", musicProject=" + musicProject +
                ", locationRollup=" + locationRollup +
                ", duration='" + duration + '\'' +
//                ", choirRollup=" + choirRollup +
                ", location=" + location +
                '}';
    }
}
