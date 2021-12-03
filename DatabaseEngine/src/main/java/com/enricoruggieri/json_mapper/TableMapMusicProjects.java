package com.enricoruggieri.json_mapper;

import com.google.gson.annotations.SerializedName;

public class TableMapMusicProjects {

    String id;
    @SerializedName("Title")
    String title;
    @SerializedName("Completed")
    Boolean isCompleted;
    @SerializedName("Cancelled")
    Boolean isCancelled;
    @SerializedName("Choirs Rollup")
    String choirsRollup;
    @SerializedName("Description")
    String description;

    public String getId() {
        return id;
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

    public String getChoirsRollup() {
        return choirsRollup;
    }

    public String getDescription() {
        return description;
    }
}
