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
import java.util.List;

public class TableRepertoire extends TableObject<TableRepertoire.TableRepertoireMap> {

    public TableRepertoire() throws IOException {
        super("Repertoire", TableRepertoireMap.class, 0);
    }

    protected List<TableRepertoireMap> initTableObject() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader((new FileReader(super.getInputFile())));
        Type repertoireListType = TypeToken.getParameterized(ArrayList.class, super.getTableClass()).getType();
        return gson.fromJson(reader, repertoireListType);
    }

    @Override
    public List<List<Object>> initValuesList() {
        return null;
    }

    //    @Override
//    public List<List<Object>> initValuesList() {
//        NotionClient client = new NotionClient(System.getenv("NOTION_TOKEN"));
//        List<TableMapRepertoireAndDivisi> databaseRepertoire = new TableObjectRepertoireAndDivisi(client).buildTable();
//        List<List<Object>> values = new ArrayList<>();
//        final String[] repertoireColumnTitles = new String[]{
//                "Order",
//                "Title",
//                "Composer",
//                "Voices",
//                "Solo",
//                "Instruments",
//                "Score",
//                "Midi",
//                "Recording",
//                "Note"
//        };
//        values.add(Arrays.asList(repertoireColumnTitles));
//        for (TableMapRepertoireAndDivisi record : databaseRepertoire) {
//            List<Object> recordList = new ArrayList<>();
//            recordList.add(record.getMusicProject().toString());
//            recordList.add(record.getOrder());
//            recordList.add(record.getMusicRollup());
//            recordList.add(record.getComposerRollup());
//            recordList.add(record.getVoicesRollup());
//            recordList.add(record.getSoloRollup());
//            recordList.add(record.getInstrumentRollup()
//                    .toString().substring(1,record.getInstrumentRollup().toString().length() - 1));
//            recordList.add(record.getScoreRollup());
//            recordList.add(record.getMediaRollup());
//            recordList.add(record.getRecordingRollup());
//            recordList.add(record.getNote());
//            values.add(recordList);
//        }
//        return values;
//    }

    protected static class TableRepertoireMap {
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

        public String getOrder() {
            return order;
        }

    }
}
