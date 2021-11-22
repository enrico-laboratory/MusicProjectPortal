package com.enricoruggieri.json_to_gspreadsheet;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SheetSchedule extends SheetCreator {


    public SheetSchedule(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId,0, "Schedule", new TableSchedule());
    }

    @Override
    public String changeDateFormat() throws IOException {
        return getService().changeDateFormat(getSpreadsheetId(),getSheetName());
    }

    public String setColumnDimensionTo80() {
        return "no changes";
    }
}
