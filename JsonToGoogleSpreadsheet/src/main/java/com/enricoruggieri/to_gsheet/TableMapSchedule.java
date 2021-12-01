package com.enricoruggieri.to_gsheet;

import com.enricoruggieri.notion_client.NotionWrapper;
import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapSchedule {

    private final String task;
    private final String type;
    private final String doDateStart;
    private final String doDateEnd;
    private final List<String> musicProject;
    private final List<String> locationRollup;
    private final String duration;
//    private final List<String> choirRollup;
    private final List<String> location;

    public TableMapSchedule(String task,
                            String type,
                            String doDateStart,
                            String doDateEnd,
                            List<String> musicProject,
                            List<String> locationRollup,
                            String duration,
                            List<String> location)
    {
        this.task = task;
        this.type = type;
        this.doDateStart = doDateStart;
        this.doDateEnd = doDateEnd;
        this.musicProject = musicProject;
        this.locationRollup = locationRollup;
        this.duration = duration;
        this.location = location;
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
