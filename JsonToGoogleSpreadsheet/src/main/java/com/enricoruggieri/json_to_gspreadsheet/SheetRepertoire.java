package com.enricoruggieri.json_to_gspreadsheet;

import com.enricoruggieri.google_api_client.GoogleAPIClient;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SheetRepertoire extends SheetCreator {

    public SheetRepertoire(String spreadSheetId, String projectId) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, 0, "Repertoire", new TableRepertoire());
    }


    @Override
    public String changeDateFormat() {
        return "no changes";
    }

    public String setColumnDimensionTo80() throws IOException {
        GoogleAPIClient service = getService();
        Integer endIndex = 9;
        Integer startIndex = 6;
        return service.setColumnDimensionTo80(getSpreadsheetId(), getSheetName(), startIndex, endIndex);
    }

}
