package com.enricoruggieri.json_mapper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableMapDivisi {
    String id;
    @SerializedName("Music Projects")
    List<String> musicProject;
    @SerializedName("Selected")
    boolean selected;
    @SerializedName("Order")
    String order;
    @SerializedName("Music Rollup")
    String music;
    @SerializedName("Composer")
    String composer;
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

    public List<String> getMusicProject() {
        return musicProject;
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

    public String getV1() {
        return v1;
    }

    public String getV2() {
        return v2;
    }

    public String getV3() {
        return v3;
    }

    public String getV4() {
        return v4;
    }

    public String getV5() {
        return v5;
    }

    public String getV6() {
        return v6;
    }

    public String getV7() {
        return v7;
    }

    public String getV8() {
        return v8;
    }

    public String getV9() {
        return v9;
    }

    public String getV10() {
        return v10;
    }

    public String getV11() {
        return v11;
    }

    public String getV12() {
        return v12;
    }
}
