package com.enricoruggieri.json_mapper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableMapSchedule {

    String id;
    @SerializedName("Music Projects")
    List<String> musicProject;
    @SerializedName("Type")
    String type;
    @SerializedName("Do Date")
    DoDate doDate;
    @SerializedName("Duration")
    String duration;
    @SerializedName("Location Rollup")
    String location;
    @SerializedName("Task")
    String task;

    public String getId() {
        return id;
    }

    public List<String> getMusicProject() {
        return musicProject;
    }

    public String getType() {
        return type;
    }

    public DoDate getDoDate() {
        return doDate;
    }

    public String getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public String getTask() {
        return task;
    }

    public String getStart() {
        return doDate.start;
    }

    public String getEnd() {
        return doDate.end;
    }


    private class DoDate {
        String start;
        String end;

        @Override
        public String toString() {
            return "DoDate{" +
                    "start='" + start + '\'' +
                    ", end='" + end + '\'' +
                    '}';
        }

        public String getType() {
            return type;
        }
    }
}