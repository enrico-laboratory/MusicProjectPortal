package com.enricoruggieri.database_engine.to_google_sheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetDivisi extends SheetBuilder {

    public SheetDivisi(String spreadSheetId, String projectId, List<List<Object>> valuesList) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, "Divisi", 0, valuesList);
    }

    @Override
    public String changeDateFormat() {
        return "no changes";
    }

    @Override
    public String setColumnDimension() {
        return "no changes";
    }
}
