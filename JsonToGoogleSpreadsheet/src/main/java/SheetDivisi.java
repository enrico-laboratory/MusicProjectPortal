import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetDivisi extends SheetCreator {

    public SheetDivisi(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, 0, "Divisi", new TableRepertoireDivisi());
    }

    @Override
    public void setColumnDimensionTo80() throws IOException {
    }
}
