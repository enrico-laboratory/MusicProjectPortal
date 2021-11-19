import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetRepertoire extends SheetCreator {

    public SheetRepertoire(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, 0, "Repertoire", new TableRepertoire());
    }


    @Override
    public void changeDateFormat() throws IOException {

    }

    public void setColumnDimensionTo80() throws IOException {
        GoogleAPIClient service = getService();
        Integer endIndex = 9;
        Integer startIndex = 6;
        service.setColumnDimensionTo80(getSpreadsheetId(), getSheetName(), startIndex, endIndex);
    }

}
