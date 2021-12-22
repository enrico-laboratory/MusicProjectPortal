package com.enricoruggieri.database_engine.to_google_sheet.sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetCast extends SheetBuilder {

    public SheetCast(String spreadSheetId, String projectId, List<List<Object>> valuesList) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, "Cast", 0, valuesList);
    }

    @Override
    public String setColumnDimension() {
        return "no changes";
    }

    @Override
    public String changeDateFormat() {
        return "no changes";

    }

}
