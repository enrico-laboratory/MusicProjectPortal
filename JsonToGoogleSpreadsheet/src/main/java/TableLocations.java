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

public class TableLocations extends TableObject<TableLocations.TableLocationsMap> {

    public TableLocations() throws IOException {
        super("Locations", TableLocationsMap.class, 0);
    }

    public List<TableLocationsMap> initTableObject() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader((new FileReader(super.getInputFile())));
        Type locationsListType = TypeToken.getParameterized(ArrayList.class, super.getTableClass()).getType();
        return gson.fromJson(reader, locationsListType);
    }
    public List<List<Object>> initValuesList() {
        List<List<Object>> values = new ArrayList<>();
        final String[] repertoireColumnTitles = new String[]{
                "Location",
                "Address",
                "City"
        };
        values.add(Arrays.asList(repertoireColumnTitles));
        for (TableLocationsMap record : getTableObject()) {
            List<Object> recordList = new ArrayList<>();
            recordList.add(record.tasks.toString());
            recordList.add(record.name);
            recordList.add(record.address);
            recordList.add(record.city);

            values.add(recordList);
        }
        return values;
    }

    protected static class TableLocationsMap {
        @SerializedName("Tasks")
        List<String> tasks;
        String id;
        @SerializedName("\ufeffName")
        String name;
        @SerializedName("Address")
        String address;
        @SerializedName("City")
        String city;
    }
}
