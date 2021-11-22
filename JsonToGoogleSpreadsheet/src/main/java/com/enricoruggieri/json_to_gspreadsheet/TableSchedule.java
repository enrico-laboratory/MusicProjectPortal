package com.enricoruggieri.json_to_gspreadsheet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TableSchedule extends TableObject<TableSchedule.TableTasksMap> {


    public TableSchedule() throws IOException {
        super("Schedule", TableTasksMap.class, 0);
    }

    protected List<TableTasksMap> initTableObject() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader((new FileReader("json/Tasks.json")));
        Type tasks = TypeToken.getParameterized(ArrayList.class, super.getTableClass()).getType();
        return gson.fromJson(reader, tasks);
    }

    public List<List<Object>> initValuesList() {
        List<List<Object>> values = new ArrayList<>();
        final String[] scheduleColumnTitles = new String[]{
                "Date",
                "Start Time",
                "End Time",
                "Type",
                "Program",
                "Duration",
                "Location",
        };
        values.add(Arrays.asList(scheduleColumnTitles));
        for (TableTasksMap record : getTableObject()) {
            try {
                if (record.type.equals("Rehearsal") || record.type.equals("Concert")) {
                    List<Object> recordList = new ArrayList<>();
                    recordList.add(record.musicProject);
                    try {
                        String date = Objects.requireNonNullElse(record.getStart().substring(0, 10),"");
                        recordList.add(date);  // Date

                    } catch (NullPointerException e) {
                        recordList.add("");
                    }
                    try {
                        if (record.getStart().length() > 10) {
                            recordList.add(record.getStart().substring(11, 16)); // Start Time
                        } else {
                            recordList.add("");
                        }
                    } catch (NullPointerException e) {
                        recordList.add("");
                    }
                    try {
                        if (record.getEnd().length() > 10) {
                            recordList.add(record.getEnd().substring(11, 16)); // End Time
                        } else {
                            recordList.add("");
                        }
                    } catch (NullPointerException e) {
                        recordList.add("");
                    }
                    recordList.add(record.type);
                    recordList.add(record.task); // Program
                    recordList.add(record.duration);
                    recordList.add(record.location);
                    values.add(recordList);
                }
            } catch (NullPointerException ignored){}

        }
        return values;
    }

    protected class TableTasksMap {
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
        }

        @Override
        public String toString() {
            return "TableTasks{" +
                    "id='" + id + '\'' +
                    ", musicProject=" + musicProject +
                    ", type='" + type + '\'' +
                    ", doDate=" + doDate +
                    ", duration='" + duration + '\'' +
                    ", location='" + location + '\'' +
                    ", task='" + task + '\'' +
                    '}';
        }
    }
}
