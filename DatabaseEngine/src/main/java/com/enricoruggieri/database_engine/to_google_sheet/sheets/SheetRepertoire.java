package com.enricoruggieri.database_engine.to_google_sheet.sheets;

import com.enricoruggieri.google_api_client.GoogleAPIWrapper;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetRepertoire extends SheetBuilder {

    public SheetRepertoire(String spreadSheetId, String projectId, List<List<Object>> valuesList) throws GeneralSecurityException, IOException {
        super(spreadSheetId, projectId, "Repertoire",0 , valuesList);
    }

    @Override
    public String changeDateFormat() {
        return "no changes";
    }

    public String setColumnDimension() throws IOException {
        GoogleAPIWrapper service = getService();
        Integer endIndex = 9;
        Integer startIndex = 6;
        Integer pixelSize = 80;
        return service.setColumnDimension(getSpreadsheetId(), getSheetName(), startIndex, endIndex, pixelSize);
    }

}
