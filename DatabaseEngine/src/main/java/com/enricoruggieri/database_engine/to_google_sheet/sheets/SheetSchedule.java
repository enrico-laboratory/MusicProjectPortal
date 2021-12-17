package com.enricoruggieri.database_engine.to_google_sheet.sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetSchedule extends SheetBuilder {


    public SheetSchedule(String spreadSheetId, String projectId, List<List<Object>> valuesList) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, "Schedule", 0, valuesList);
    }

    @Override
    public String changeDateFormat() throws IOException {
        return getService().changeDateFormat(getSpreadsheetId(),getSheetName());
    }

    @Override
    public String setColumnDimension() {
        return "no changes";
    }

    @Override
    public String sortSheet() {
        return "no changes";
    }
}
