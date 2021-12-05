package com.enricoruggieri.database_engine.to_google_sheet.sheets;

import com.enricoruggieri.google_api_client.GoogleAPIWrapper;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SpreadsheetCreator {

    private final String spreadsheetId;
    private final String spreadsheetTitle;
    private final String projectId;
    private final GoogleAPIWrapper service;
    private final String folderId;

    public SpreadsheetCreator(String spreadsheetTitle, String projectId, String folderId) throws IOException, GeneralSecurityException {
        this.spreadsheetTitle = spreadsheetTitle;
        this.projectId = projectId;
        this.folderId = folderId;
        this.service = new GoogleAPIWrapper();
        this.spreadsheetId = setSpreadSheetId();
    }

    private String setSpreadSheetId() throws IOException {
        if (service.searchFileInFolder(this.spreadsheetTitle, folderId).isEmpty()) {
            return service.createSpreadSheet(this.spreadsheetTitle, folderId);
        }
        return service.getFileId(this.spreadsheetTitle, folderId);
    }

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public String getSpreadsheetTitle() {
        return spreadsheetTitle;
    }

    public String getProjectId() {
        return projectId;
    }

    public void deleteDefaultSheet() throws IOException {
        this.service.deleteSheet(spreadsheetId, "Sheet1");
    }
}
