package com.enricoruggieri.database_engine.to_google_sheet;

import com.enricoruggieri.google_api_client.GoogleAPIClient;
import com.enricoruggieri.json_to_gspreadsheet.TableObject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public abstract class SheetBuilder {

    private final String spreadsheetId;
    private final String projectId;
    private final String sheetName;
    private final GoogleAPIClient service;
    private final Integer dimensionIndex;
    private final List<List<Object>> valuesList;

    public SheetBuilder(String spreadSheetId,
                        String projectId,
                        String sheetName,
                        Integer dimensionIndex,
                        List<List<Object>> valuesList) throws GeneralSecurityException, IOException
    {
        this.spreadsheetId = spreadSheetId;
        this.projectId = projectId;
        this.sheetName = sheetName;
        this.service = new GoogleAPIClient();
        this.dimensionIndex = dimensionIndex;
        this.valuesList = valuesList;
    }

    public Integer updateSheet() throws IOException {
        return this.service.updateSheet(spreadsheetId,sheetName + "!A1:Z100", valuesList);
    }

    public String makeFirstRowBold() throws IOException {
        return this.service.makeFirstRowBold(spreadsheetId, sheetName);
    }

    public String setTextWrappingClip() throws IOException {
        return this.service.setTextWrappingClip(spreadsheetId, sheetName);
    }

    public String setColumnDimensionAuto() throws IOException {
        return this.service.setColumnDimensionAuto(spreadsheetId, sheetName);
    }

    public abstract String setColumnDimension() throws IOException;

    public String clearSheet() throws IOException {
        return this.service.clearSheet(spreadsheetId, sheetName);
    }

    public String addSheet() throws IOException {
        return service.addSheet(spreadsheetId, sheetName);
    }

    public String sortSheet() throws IOException {
        return service.sortRows(spreadsheetId, sheetName, dimensionIndex);
    }

    public abstract String changeDateFormat() throws IOException;

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public List<List<Object>> getValuesList() {
        return valuesList;
    }

    public String getSheetName() {
        return sheetName;
    }

    public GoogleAPIClient getService() {
        return service;
    }

    public String getProjectId() {
        return projectId;
    }
}