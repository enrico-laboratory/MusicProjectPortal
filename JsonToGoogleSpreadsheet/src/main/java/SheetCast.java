import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class SheetCast extends SheetCreator {

    public SheetCast(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, 0, "Cast", new TableCast());
    }

    public void setColumnDimensionTo80() {
    }

    @Override
    public List<List<Object>> parseList() {
        List<List<Object>> newParsedValues = new ArrayList<>();
        newParsedValues.add(getValuesList().get(0));
        for (int i = 1; i < getValuesList().size(); i++) {
            if (getValuesList().get(i).get(0).toString().contains(this.getProjectId()) &&
            getValuesList().get(i).get(5).toString().contains("Confirmed")) {
                newParsedValues.add(getValuesList().get(i));
            }
        }
        for (int i = 1; i < newParsedValues.size(); i++) {
            newParsedValues.get(i).remove(0);
            newParsedValues.get(i).remove(4);
        }
        return newParsedValues;
    }

    @Override
    public void changeDateFormat() throws IOException {

    }
}
