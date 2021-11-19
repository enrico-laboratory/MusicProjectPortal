import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetSchedule extends SheetCreator {


    public SheetSchedule(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId,0, "Schedule", new TableSchedule());
    }

    @Override
    public void changeDateFormat() throws IOException {
        getService().changeDateFormat(getSpreadsheetId(),getSheetName());
    }

    public void setColumnDimensionTo80() {
    }
}
