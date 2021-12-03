package com.enricoruggieri.json_to_gspreadsheet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class TableMusicProjects extends TableObject<TableMusicProjects.TableMusicProjectsMap> {

//    private final List<TableMusicProjectsMap> tableObject;


    public TableMusicProjects() throws IOException {
        super("Music Projects", TableMusicProjectsMap.class, 0);
//        if (setTableObject()) {
//            this.tableObject = initTableObject();
//        } else {
//            this.tableObject = null;
//            // TODO not sure about this check solution, ask.
//            System.out.println("Project titles are not unique!");
//            System.exit(1);
//        }
    }

    protected List<TableMusicProjectsMap> initTableObject() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader((new FileReader(getInputFile())));
        Type musicProjects = TypeToken.getParameterized(ArrayList.class, super.getTableClass()).getType();
        return gson.fromJson(reader, musicProjects);
    }

    public List<String> getProjectsIdList() {
        List<String> projectsIdList = new ArrayList<>();
        for (TableMusicProjectsMap record : getTableObject()) {
            projectsIdList.add(record.getId());
        }
        return projectsIdList;
    }

    public List<TableMusicProjectsMap> isNotCompleted() {
        List<TableMusicProjectsMap> tableObjectIsNotCompleted = new ArrayList<>();
        for (TableMusicProjectsMap record : getTableObject()) {
            if (!record.isCompleted && !record.isCancelled) {
                tableObjectIsNotCompleted.add(record);
            }
        }
        return tableObjectIsNotCompleted;
    }

    public List<TableMusicProjectsMap> isCompleted() {
        List<TableMusicProjectsMap> tableObjectIsCompleted = new ArrayList<>();
        for (TableMusicProjectsMap record : getTableObject()) {
            if (record.isCompleted || record.isCancelled) {
                tableObjectIsCompleted.add(record);
            }
        }
        return tableObjectIsCompleted;
    }

    public boolean setTableObject() {
        Set<Object> list = new HashSet<>();
        for (TableMusicProjectsMap record : getTableObject()) {
            if (!list.add(record.getTitle())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<List<Object>> initValuesList() {
        List<List<Object>> values = new ArrayList<>();
        final String[] musicProjectsColumnTitle = new String[]{
                "Id",
                "Title",
                "Completed",
                "Cancelled",
                "Choirs",
                "Description",
        };
        values.add(Arrays.asList(musicProjectsColumnTitle));
        for (TableMusicProjectsMap record : getTableObject()) {
            List<Object> recordList = new ArrayList<>();
            recordList.add(record.id);
            recordList.add(record.title);
            recordList.add(record.isCompleted);
            recordList.add(record.isCancelled);
            recordList.add(record.choirsRollup);
            recordList.add(record.description);

            values.add(recordList);
        }
        return values;
    }

    public static class TableMusicProjectsMap {
        String id;
        @SerializedName("Title") String title;
        @SerializedName("Completed") Boolean isCompleted;
        @SerializedName("Cancelled") Boolean isCancelled;
        @SerializedName("Choirs Rollup") String choirsRollup;
        @SerializedName("Description") String description;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

    }
}

