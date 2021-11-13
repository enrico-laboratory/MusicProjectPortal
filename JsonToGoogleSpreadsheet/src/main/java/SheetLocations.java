import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class SheetLocations extends SheetCreator {


    public SheetLocations(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, 0, "Locations", new TableLocations());
    }

    @Override
    // TODO to rethink.
    public List<List<Object>> parseList() throws GeneralSecurityException, IOException {
        List<List<Object>> newParsedValues = new ArrayList<>();

        List<List<Object>> valuesSchedule = new TableSchedule().initValuesList();

        newParsedValues.add(getValuesList().get(0));

        for (int i = 1; i < getValuesList().size(); i++) {
            for (List<Object> objects : valuesSchedule) {
                if (objects.get(3).equals(getValuesList().get(i).get(0)))
                    newParsedValues.add(getValuesList().get(i));
            }
        }
        for (int i = 1; i < newParsedValues.size(); i++) {
            newParsedValues.get(i).remove(0);
            newParsedValues.get(i).remove(4);
        }
        return newParsedValues;
    }
    public void setColumnDimensionTo80() throws IOException {
    }
}
