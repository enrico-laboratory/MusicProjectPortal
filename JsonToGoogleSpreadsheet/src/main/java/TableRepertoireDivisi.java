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

public class TableRepertoireDivisi extends TableObject<TableRepertoireDivisi.TableRepertoireDivisiMap> {


    public TableRepertoireDivisi() throws IOException {
        super("Divisi", TableRepertoireDivisiMap.class, 0);
    }

    protected List<TableRepertoireDivisiMap> initTableObject() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader((new FileReader("json/Repertoire.json")));
        Type repertoireListType = TypeToken.getParameterized(ArrayList.class, super.getTableClass()).getType();
        return gson.fromJson(reader, repertoireListType);
    }

    @Override
    public List<List<Object>> initValuesList() {
        List<List<Object>> values = new ArrayList<>();
        final String[] divisiColumnTitles = new String[]{
                "Order",
                "Title",
                "Composer",
                "1 - top voice",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12"
        };

        values.add(Arrays.asList(divisiColumnTitles));

        for (TableRepertoireDivisiMap record : getTableObject()) {
            List<Object> recordList = new ArrayList<>();
            recordList.add(record.musicProject);
            recordList.add(record.order);
            recordList.add(record.music);
            recordList.add(record.composer);
            recordList.add(record.v1);
            recordList.add(record.v2);
            recordList.add(record.v3);
            recordList.add(record.v4);
            recordList.add(record.v5);
            recordList.add(record.v6);
            recordList.add(record.v7);
            recordList.add(record.v8);
            recordList.add(record.v9);
            recordList.add(record.v10);
            recordList.add(record.v11);
            recordList.add(record.v12);

            values.add(recordList);
        }
        return values;
    }

    protected static class TableRepertoireDivisiMap {
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

        public String getOrder() {
            return order;
        }

    }
}
