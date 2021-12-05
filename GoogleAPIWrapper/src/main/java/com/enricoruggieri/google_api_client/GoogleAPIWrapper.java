package com.enricoruggieri.google_api_client;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoogleAPIWrapper {

    private final Drive driveService = new GoogleAPIService().createDriveService();
    private final Sheets sheetsService = new GoogleAPIService().createSheetsService();

    public GoogleAPIWrapper() throws GeneralSecurityException, IOException {
    }

    public String clearSheet(String spreadsheetId, String sheetName) throws IOException {

        String range = sheetName + "!A1:Z1000";
        ClearValuesRequest requestBody = new ClearValuesRequest();
        Sheets.Spreadsheets.Values.Clear
                request = this.sheetsService.spreadsheets().values()
                .clear(spreadsheetId, range, requestBody);

        return request.execute().getClearedRange();
    }

    public Integer updateSheet(String spreadsheetId, String range, List<List<Object>> values)
            throws IOException {

        String VALUE_INPUT_OPTION = "USER_ENTERED";
        ValueRange body = new ValueRange().setValues(values);

        UpdateValuesResponse result = this.sheetsService.spreadsheets().values().update(spreadsheetId, range, body)
                .setValueInputOption(VALUE_INPUT_OPTION).execute();
        return result.getUpdatedCells();

    }

    public String sortRows(String spreadsheetId, String sheetTitle, int dimensionIndex) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId, sheetTitle);
        GridRange gridRange = setGridRange(sheetId, 1, 1004, 0, 25);

        List<Request> request = List.of(new Request()
                .setSortRange(new SortRangeRequest()
                        .setRange(gridRange)
                        .setSortSpecs(List.of(new SortSpec()
                                .setSortOrder("ASCENDING")
                                .setDimensionIndex(dimensionIndex)))));

        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(request);

        return this.sheetsService.spreadsheets()
                .batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute().getReplies().toString();

    }

    public Integer sheetIdByTitle(String spreadsheetId, String sheetName) throws IOException {
        Spreadsheet sheetObject = sheetsService.spreadsheets().get(spreadsheetId).execute();

        for (Sheet sheet : sheetObject.getSheets()) {
            if (sheet.getProperties().getTitle().equals(sheetName)) {
                return sheet.getProperties().getSheetId();
            }
        }
        return -1;
    }

    public String setColumnDimensionAuto(String spreadsheetId, String sheetName) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);
        DimensionRange dimensionRange = setDimensionRange(sheetId, 0, 25, "COLUMNS");

        List<Request> requests = List.of(
                new Request()
                        .setAutoResizeDimensions(new AutoResizeDimensionsRequest()
                                .setDimensions(dimensionRange)
                        )
        );
        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(requests);

        return this.sheetsService.spreadsheets().batchUpdate(
                        spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute().getReplies().toString();
    }
    public String setColumnDimension(String spreadsheetId, String sheetName, Integer startIndex, Integer endIndex, Integer pixelSize) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);
        DimensionRange dimensionRange = setDimensionRange(sheetId, startIndex, endIndex, "COLUMNS");

        List<Request> requests = List.of(
                new Request()
                        .setUpdateDimensionProperties(
                                new UpdateDimensionPropertiesRequest()
                                        .setProperties(new DimensionProperties()
                                                .setPixelSize(pixelSize))
                                        .setRange(dimensionRange)
                                        .setFields("pixelSize"))
        );
        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(requests);

        return this.sheetsService.spreadsheets()
                .batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute().getReplies().toString();
    }

    private DimensionRange setDimensionRange(Integer sheetId, Integer startIndex, Integer endIndex, String dimensionSpan) {
        return new DimensionRange()
                .setSheetId(sheetId)
                .setDimension(dimensionSpan)
                .setStartIndex(startIndex)
                .setEndIndex(endIndex);
    }
    public String setTextWrappingClip(String spreadsheetId, String sheetName) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);
        GridRange gridRange = setGridRangeOnlyColumn(sheetId, 6,9);

        List<Request> requests = List.of(
                new Request().setRepeatCell(new RepeatCellRequest()
                        .setRange(gridRange)
                        .setCell(new CellData()
                                .setUserEnteredFormat(new CellFormat()
                                        .setWrapStrategy("CLIP")
                                )
                        )
                        .setFields("userEnteredFormat.wrapStrategy")
                )
        );
        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(requests);

        return this.sheetsService.spreadsheets()
                .batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute().getReplies().toString();
    }

    public String changeDateFormat(String spreadsheetId, String sheetTitle) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId, sheetTitle);
        GridRange gridRange = setGridRangeOnlyColumn(sheetId,0,1);

        List<Request> request = List.of(
                new Request().setRepeatCell(
                        new RepeatCellRequest()
                                .setRange(gridRange)
                                .setCell(
                                        new CellData()
                                                .setUserEnteredFormat(new CellFormat()
                                                        .setNumberFormat(new NumberFormat()
                                                                .setType("DATE")
                                                                .setPattern("ddd dd mmm yyyy")))
                                )
                                .setFields("userEnteredFormat.numberFormat")
                )
        );
        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest = new BatchUpdateSpreadsheetRequest()
                .setRequests(request);

        return this.sheetsService.spreadsheets()
                .batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute().getReplies().toString();
    }

    public String makeFirstRowBold(String spreadsheetId, String sheetName) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);

        GridRange gridRange = setGridRangeOnlyRow(sheetId, 0,1);

        List<Request> requests = List.of(
                new Request().setRepeatCell(new RepeatCellRequest()
                        .setRange(gridRange)
                        .setCell(new CellData()
                                .setUserEnteredFormat(new CellFormat()
                                        .setTextFormat(new TextFormat()
                                                .setBold(true)
                                        )
                                )
                        )
                        .setFields("userEnteredFormat.textFormat.bold")
                )
        );
        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(requests);

        return this.sheetsService.spreadsheets().batchUpdate(
                spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute().getReplies().toString();
    }

    private GridRange setGridRangeOnlyColumn(Integer sheetId, Integer startColumnIndex, Integer endColumnIndex){
        return setGridRange(sheetId, null, null, startColumnIndex, endColumnIndex);

    }

    private GridRange setGridRangeOnlyRow(Integer sheetId, Integer startRowIndex, Integer endRowIndex){
        return setGridRange(sheetId,startRowIndex,endRowIndex, null, null);

    }

    private GridRange setGridRange(Integer sheetId, Integer startRowIndex, Integer endRowIndex, Integer startColumnIndex, Integer endColumnIndex) {
        return new GridRange()
                .setSheetId(sheetId)
                .setStartRowIndex(startRowIndex)
                .setEndRowIndex(endRowIndex)
                .setStartColumnIndex(startColumnIndex)
                .setEndColumnIndex(endColumnIndex);

    }

    public String addSheet(String spreadsheetId, String title) throws IOException {

        List<Request> request = List.of(
                new Request()
                        .setAddSheet(new AddSheetRequest()
                                .setProperties(new SheetProperties()
                                        .setTitle(title))));

        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(request);

        BatchUpdateSpreadsheetResponse response = null;

        try {
            response = this.sheetsService.spreadsheets().batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest)
                    .execute();
        } catch (GoogleJsonResponseException ignored){}

        return response.getReplies().toString();
    }


    public BatchUpdateSpreadsheetResponse deleteSheet(String spreadSheetId, String sheetName) throws IOException {
        BatchUpdateSpreadsheetResponse response = null;

        Integer sheetId = sheetIdByTitle(spreadSheetId, sheetName);

        List<Request> request = List.of(
                new Request()
                        .setDeleteSheet(new DeleteSheetRequest()
                                .setSheetId(sheetId)));

        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(request);

        try{
            response = this.sheetsService
                    .spreadsheets()
                    .batchUpdate(spreadSheetId, batchUpdateSpreadsheetRequest)
                    .execute();
        } catch (GoogleJsonResponseException ignored) {}
        return response;
    }


    public String createFolder(String name) throws IOException {
        return createFolder(name, "null");
    }
    public String createFolder(String name, String parentFolderId) throws IOException {
        return createItem(name,parentFolderId, "application/vnd.google-apps.folder" );
    }

    public String createSpreadSheet(String name) throws IOException {
        return createItem(name,"null", "application/vnd.google-apps.spreadsheet");
    }
    public String createSpreadSheet(String name, String parentFolderId) throws IOException {
        return createItem(name,parentFolderId, "application/vnd.google-apps.spreadsheet");
    }

    private String createItem(String name, String parentFolderId, String mimeType) throws IOException {
        File fileMetadata = new File();

        if (parentFolderId.equals("null")) {
            fileMetadata.setName(name)
                    .setMimeType(mimeType);
        }

        fileMetadata.setName(name)
                .setParents(Collections.singletonList(parentFolderId))
                .setMimeType(mimeType);

        return this.driveService.files().create(fileMetadata).setFields("id").execute().getId();
    }

    public String getFileId(String fileName, String folderId) throws IOException {
        List<File> result = searchFileInFolder(fileName, folderId);
        String id = result.get(0).toString();
        return id.substring(7, id.length() - 2);
    }

    public boolean isSearchSingleton(List<File> searchFileResult) {
        return searchFileResult.size() <= 1;
    }

    public List<File> searchFile(String fileName) throws IOException {
        String query = "mimeType!='application/vnd.google-apps.folder' and name='" + fileName + "'";
        return searchItem(fileName, query);
    }
    public List<File> searchFileInFolder(String fileName, String folderId) throws IOException {
        String query = "mimeType!='application/vnd.google-apps.folder' and name='" + fileName + "' and parents in '" + folderId + "'";
        return searchItem(fileName, query);
    }
    public List<File> searchFolder(String folderName) throws IOException {
        String query = "mimeType='application/vnd.google-apps.folder' and name='" + folderName + "'";
        return searchItem(folderName, query);
    }

    public List<File> searchItem(String fileName, String query) throws IOException {
        String pageToken = null;
        FileList result;
        do {
            result = driveService.files().list()
                    .setQ(query)
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id)")
                    .setPageToken(pageToken)
                    .execute();
            pageToken = result.getNextPageToken();
        } while (pageToken != null);

        return result.getFiles();
    }

    private static class GoogleAPIService {
        private final String APPLICATION_NAME = "Music Projects Portal";
        private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        private final String TOKENS_DIRECTORY_PATH = "tokens";
        private final List<String> SCOPES = Collections.singletonList(SheetsScopes.DRIVE);
        private final String CREDENTIALS_FILE_PATH = "/credentials.json";

        public Sheets createSheetsService() throws IOException, GeneralSecurityException {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }

        public Drive createDriveService() throws IOException, GeneralSecurityException {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }

        private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
            // Load client secrets.
            InputStream in = GoogleAPIService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            }
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                    .setAccessType("offline")
                    .build();
            LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
            return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        }
    }
}


