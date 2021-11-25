package com.enricoruggieri.notion_database_parser;

import java.util.List;

public class RecordFieldsMusicProjects extends RecordFields{

    private final String projectId;
    private final String title;
    private final Boolean isCompleted;
    private final Boolean isCancelled;
    private final List<String> choirs;
    private final List<String> choirsRollup;
    private final String description;

    public RecordFieldsMusicProjects(String projectId,
                                     String title,
                                     Boolean isCompleted,
                                     Boolean isCancelled,
                                     List<String> choirs,
                                     List<String> choirsRollup,
                                     String description)
    {
        this.projectId = projectId;
        this.title = title;
        this.isCompleted = isCompleted;
        this.isCancelled = isCancelled;
        this.choirs = choirs;
        this.choirsRollup = choirsRollup;
        this.description = description;
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

    public List<String> getChoirs() {
        return choirs;
    }

    public List<String> getChoirsRollup() {
        return choirsRollup;
    }

    public String getDescription() {
        return description;
    }
}
