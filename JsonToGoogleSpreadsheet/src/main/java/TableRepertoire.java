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
        List<List<Object>> values = new ArrayList<>();
        final String[] repertoireColumnTitles = new String[]{
                "Order",
                "Title",
                "Composer",
                "Voices",
                "Solo",
                "Instruments",
                "Score",
                "Midi",
                "Recording",
                "Note"
        };
        values.add(Arrays.asList(repertoireColumnTitles));
        for (TableRepertoireMap record : getTableObject()) {
            List<Object> recordList = new ArrayList<>();
            recordList.add(record.musicProject);
            recordList.add(record.order);
            recordList.add(record.music);
            recordList.add(record.composer);
            recordList.add(record.voices);
            recordList.add(record.solo);
            recordList.add(record.instruments
                    .toString().substring(1,record.instruments.toString().length() - 1));
            recordList.add(record.score);
            recordList.add(record.media);
            recordList.add(record.recording);
            recordList.add(record.note);
            values.add(recordList);
        }
        return values;
    }

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
