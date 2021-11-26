package com.enricoruggieri.json_mapper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableMapCast {
    @SerializedName("Music Project")
    List<String> musicProject;
    String id;
    @SerializedName("Singers Rollup")
    String singer;
    @SerializedName("Notes")
    String notes;
    @SerializedName("Email")
    String email;
    @SerializedName("Role")
    String role;
    @SerializedName("Status")
    String status;

    public List<String> getMusicProject() {
        return musicProject;
    }

    public String getId() {
        return id;
    }

    public String getSinger() {
        return singer;
    }

    public String getNotes() {
        return notes;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }
}
