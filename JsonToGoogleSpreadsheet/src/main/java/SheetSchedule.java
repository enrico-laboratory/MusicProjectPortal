import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetSchedule extends SheetCreator {


    public SheetSchedule(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId,0, "Schedule", new TableSchedule());
    }

    public void setColumnDimensionTo80() throws IOException {
    }
}
