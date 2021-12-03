package com.enricoruggieri.json_mapper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableMapRepertoireAndDivisi extends TableMapObject {
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
    @SerializedName("1 - Top Voice")
    String v1;
    @SerializedName("2")
    String v2;
    @SerializedName("3")
    String v3;
    @SerializedName("4")
    String v4;
    @SerializedName("5")
    String v5;
    @SerializedName("6")
    String v6;
    @SerializedName("7")
    String v7;
    @SerializedName("8")
    String v8;
    @SerializedName("9")
    String v9;
    @SerializedName("10")
    String v10;
    @SerializedName("11")
    String v11;
    @SerializedName("12")
    String v12;

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
