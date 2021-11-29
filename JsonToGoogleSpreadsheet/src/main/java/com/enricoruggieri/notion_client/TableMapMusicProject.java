package com.enricoruggieri.notion_client;

import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapMusicProject extends TableMapObject {

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

    public TableMapMusicProject(Page page)
    {
        super(page);
        this.projectId = NotionWrapper.getId(page, Config.MUSIC_PROJECT_ID);
        this.title = NotionWrapper.getTitleValue(page, Config.MUSIC_PROJECT_TITLE);
        this.isCompleted = NotionWrapper.getCheckbox(page, Config.MUSIC_PROJECT_COMPLETED);
        this.isCancelled = NotionWrapper.getCheckbox(page, Config.MUSIC_PROJECT_CANCELLED);
        this.choir = NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_CHOIR);
        this.choirRollup = NotionWrapper.getTitleValueRollup(page, Config.MUSIC_PROJECT_CHOIR_ROLLUP);
        this.description = NotionWrapper.getRichText(page, Config.MUSIC_PROJECT_DESCRIPTION);
        this.task = NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_TASK);
        this.taskRollup = NotionWrapper.getTitleValueRollup(page, Config.MUSIC_PROJECT_TASKS_ROLLUP);
        this.cast = NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_CAST);
        this.repertoire = NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_REPERTOIRE);
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
