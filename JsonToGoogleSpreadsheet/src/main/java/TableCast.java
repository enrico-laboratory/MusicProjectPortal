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

public class TableCast extends TableObject<TableCast.TableCastMap> {

    public TableCast() throws IOException {
        super("Cast", TableCastMap.class, 0);
    }

    protected List<TableCastMap> initTableObject() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader((new FileReader(super.getInputFile())));
        Type castListType = TypeToken.getParameterized(ArrayList.class, super.getTableClass()).getType();
        return gson.fromJson(reader, castListType);
    }
    public List<List<Object>> initValuesList() {
        List<List<Object>> values = new ArrayList<>();
        final String[] castColumnTitles = new String[]{
                "Role",
                "Name",
                "Email",
                "Notes"
        };
        values.add(Arrays.asList(castColumnTitles));
        for (TableCastMap record : getTableObject()) {
            List<Object> recordList = new ArrayList<>();

            recordList.add(record.musicProject);
            recordList.add(record.role);
            recordList.add(record.singer);
            recordList.add(record.email);
            recordList.add(record.notes);
            recordList.add(Objects.requireNonNullElse(record.status, ""));
            values.add(recordList);
        }
        return values;
    }

    protected static class TableCastMap {
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
    }
}
