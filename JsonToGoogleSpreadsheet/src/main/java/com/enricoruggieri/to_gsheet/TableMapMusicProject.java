package com.enricoruggieri.to_gsheet;

import com.enricoruggieri.notion_client.NotionWrapper;
import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapMusicProject {

    private final String projectId;
    private final String title;
    private final Boolean isCompleted;
    private final Boolean isCancelled;
    private final List<String> choir;
    private final List<String> choirRollup;
    private final String description;
    private final List<String> task;
    private final List<String> taskRollup;
    private final List<String> cast;
    private final List<String> repertoire;

    public TableMapMusicProject(String projectId, String title, Boolean isCompleted, Boolean isCancelled, List<String> choir, List<String> choirRollup, String description, List<String> task, List<String> taskRollup, List<String> cast, List<String> repertoire) {
        this.projectId = projectId;
        this.title = title;
        this.isCompleted = isCompleted;
        this.isCancelled = isCancelled;
        this.choir = choir;
        this.choirRollup = choirRollup;
        this.description = description;
        this.task = task;
        this.taskRollup = taskRollup;
        this.cast = cast;
        this.repertoire = repertoire;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public List<String> getChoir() {
        return choir;
    }

    public List<String> getChoirRollup() {
        return choirRollup;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTask() {
        return task;
    }

    public List<String> getTaskRollup() {
        return taskRollup;
    }

    public List<String> getCast() {
        return cast;
    }

    public List<String> getRepertoire() {
        return repertoire;
    }

    @Override
    public String toString() {
        return "TableMapMusicProject{" +
                "projectId='" + projectId + '\'' +
                ", title='" + title + '\'' +
                ", isCompleted=" + isCompleted +
                ", isCancelled=" + isCancelled +
                ", choir=" + choir +
                ", choirRollup=" + choirRollup +
                ", description='" + description + '\'' +
                ", task=" + task +
                ", taskRollup=" + taskRollup +
                ", cast=" + cast +
                ", repertoire=" + repertoire +
                '}';
    }
}
