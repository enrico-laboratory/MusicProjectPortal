package com.enricoruggieri.json_to_gspreadsheet;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SheetDivisi extends SheetCreator {

    public SheetDivisi(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, 0, "Divisi", new TableRepertoireDivisi());
    }

    @Override
    public String changeDateFormat() {
        return "no changes";
    }

    @Override
    public String setColumnDimensionTo80() {
        return "no changes";
    }
}
