package com.enricoruggieri.json_mapper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableMapRepertoire extends TableMapObject {
    String id;
    @SerializedName("Selected")
    boolean selected;
    @SerializedName("Order")
    String order;
    @SerializedName("Music Rollup")
    String music;
    @SerializedName("Composer")
    String composer;
    @SerializedName("Voices")
    String voices;
    @SerializedName("Solo")
    String solo;
    @SerializedName("Instruments")
    List<String> instruments;
    @SerializedName("Score Rollup")
    String score;
    @SerializedName("Media")
    String media;
    @SerializedName("Recording")
    String recording;
    @SerializedName("Note")
    String note;
    @SerializedName("Music Projects")
    List<String> musicProject;
    @SerializedName("Length Rollup")
    String length;

    public String getId() {
        return id;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getOrder() {
        return order;
    }

    public String getMusic() {
        return music;
    }

    public String getComposer() {
        return composer;
    }

    public String getVoices() {
        return voices;
    }

    public String getSolo() {
        return solo;
    }

    public List<String> getInstruments() {
        return instruments;
    }

    public String getScore() {
        return score;
    }

    public String getMedia() {
        return media;
    }

    public String getRecording() {
        return recording;
    }

    public String getNote() {
        return note;
    }

    public List<String> getMusicProject() {
        return musicProject;
    }

    public String getLength() {
        return length;
    }
}
