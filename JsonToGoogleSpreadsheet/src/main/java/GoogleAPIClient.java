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
import java.util.Properties;

public class GoogleAPIClient {

    private final Drive driveService = new GoogleAPIService().createDriveService();
    private final Sheets sheetsService = new GoogleAPIService().createSheetsService();

    public Drive getDriveService() {
        return driveService;
    }

    public Sheets getSheetsService() {
        return sheetsService;
    }

    public GoogleAPIClient() throws GeneralSecurityException, IOException {
    }

//    private Drive createDriveService() throws GeneralSecurityException, IOException {
//        return new GoogleAPIService().createDriveService();
//    }
    public ClearValuesResponse clearSheet(String spreadsheetId, String sheetName) throws IOException {

        String range = sheetName + "!A1:Z1000";
        ClearValuesRequest requestBody = new ClearValuesRequest();
        Sheets.Spreadsheets.Values.Clear
                request = this.sheetsService.spreadsheets().values()
                .clear(spreadsheetId, range, requestBody);

        return request.execute();
    }

    public Integer updateSheet(String spreadsheetId, String range, List<List<Object>> values)
            throws IOException {

        String VALUE_INPUT_OPTION = "USER_ENTERED";
        ValueRange body = new ValueRange().setValues(values);

        UpdateValuesResponse result = this.sheetsService.spreadsheets().values().update(spreadsheetId, range, body)
                .setValueInputOption(VALUE_INPUT_OPTION).execute();
        return result.getUpdatedCells();

    }

    public BatchUpdateSpreadsheetResponse sortRows(String spreadsheetId, String sheetTitle, int dimensionIndex) throws IOException {
        SortSpec sortSpec = new SortSpec();
        sortSpec.setSortOrder("ASCENDING")
                .setDimensionIndex(dimensionIndex);

        Integer sheetId = sheetIdByTitle(spreadsheetId, sheetTitle);

        GridRange gridRange = new GridRange();
        gridRange
                .setSheetId(sheetId)
                .setStartRowIndex(1)
                .setEndRowIndex(1004)
                .setStartColumnIndex(0)
                .setEndColumnIndex(25);

        SortRangeRequest sortRangeRequest = new SortRangeRequest()
                .setRange(gridRange)
                .setSortSpecs(Arrays.asList(sortSpec));

        Request request = new Request()
                .setSortRange(sortRangeRequest);

        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(Arrays.asList(request));

        return this.sheetsService.spreadsheets()
                .batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute();

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

    public BatchUpdateSpreadsheetResponse setColumnDimensionAuto(String spreadsheetId, String sheetName) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);

        DimensionRange dimensionRange = new DimensionRange();
        dimensionRange
                .setSheetId(sheetId)
                .setDimension("COLUMNS")
                .setStartIndex(0)
                .setEndIndex(25);

        List<Request> requests = Arrays.asList(
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
                .execute();
    }
    public BatchUpdateSpreadsheetResponse setColumnDimensionTo80(String spreadsheetId, String sheetName, Integer startIndex, Integer endIndex) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);

        DimensionRange dimensionRange = new DimensionRange();
        dimensionRange
                .setSheetId(sheetId)
                .setDimension("COLUMNS")
                .setStartIndex(startIndex)
                .setEndIndex(endIndex);

        List<Request> requests = Arrays.asList(
                new Request()
                        .setUpdateDimensionProperties(
                                new UpdateDimensionPropertiesRequest()
                                        .setProperties(new DimensionProperties()
                                                .setPixelSize(80))
                                        .setRange(dimensionRange)
                                        .setFields("pixelSize"))
        );
        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(requests);

        return this.sheetsService.spreadsheets().batchUpdate(
                        spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute();
    }
    public BatchUpdateSpreadsheetResponse setTextWrappingClip(String spreadsheetId, String sheetName) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);

        GridRange gridRange = new GridRange();
        gridRange
                .setSheetId(sheetId)
//                .setStartRowIndex(0)
//                .setEndRowIndex(1);
                .setStartColumnIndex(6)
                .setEndColumnIndex(9);

        List<Request> requests = Arrays.asList(
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

        return this.sheetsService.spreadsheets().batchUpdate(
                        spreadsheetId, batchUpdateSpreadsheetRequest)
                .execute();
    }

    public BatchUpdateSpreadsheetResponse makeFirstRowBold(String spreadsheetId, String sheetName) throws IOException {

        Integer sheetId = sheetIdByTitle(spreadsheetId,sheetName);

        GridRange gridRange = new GridRange();
        gridRange
                .setSheetId(sheetId)
                .setStartRowIndex(0)
                .setEndRowIndex(1);
//                .setStartColumnIndex(0)
//                .setEndColumnIndex(25);

        List<Request> requests = Arrays.asList(
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
                        .execute();
    }

    public BatchUpdateSpreadsheetResponse addSheet(String spreadsheetId, String title) throws IOException {

        SheetProperties sheetProperties = new SheetProperties()
//                .setIndex(index)
                .setTitle(title);
        AddSheetRequest addSheetRequest = new AddSheetRequest().setProperties(sheetProperties);

        Request request = new Request()
                .setAddSheet(addSheetRequest);

        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(Arrays.asList(request));

        BatchUpdateSpreadsheetResponse response = null;
        try {
            response = this.sheetsService.spreadsheets().batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest)
                    .execute();
        } catch (GoogleJsonResponseException e){
            System.out.println("Sheet '" + title + "' already exist!" );
        }
        return response;
    }


    public BatchUpdateSpreadsheetResponse deleteSheet(String spreadSheetId, String sheetName) throws IOException {
        Integer sheetId = sheetIdByTitle(spreadSheetId, sheetName);

        List<Request> request = Arrays.asList(
                new Request()
                        .setDeleteSheet(new DeleteSheetRequest()
                        .setSheetId(sheetId)));

        BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest =
                new BatchUpdateSpreadsheetRequest()
                        .setRequests(request);

        BatchUpdateSpreadsheetResponse response = null;

        try{
            response = this.sheetsService
                    .spreadsheets()
                    .batchUpdate(spreadSheetId, batchUpdateSpreadsheetRequest)
                    .execute();
        } catch (GoogleJsonResponseException ignored) {}
        return response;
    }


    public File createFolder(String name) throws IOException {
        return createFolder(name, "null");
    }
    public File createFolder(String name, String parentFolderId) throws IOException {
        return createItem(name,parentFolderId, "application/vnd.google-apps.folder" );
    }

    public File createSpreadSheet(String name) throws IOException {
        return createItem(name,"null", "application/vnd.google-apps.spreadsheet");
    }
    public File createSpreadSheet(String name, String parentFolderId) throws IOException {
        return createItem(name,parentFolderId, "application/vnd.google-apps.spreadsheet");
    }

    private File createItem(String name, String parentFolderId, String mimeType) throws IOException {
        File fileMetadata = new File();

        if (parentFolderId.equals("null")) {
            fileMetadata.setName(name)
                    .setMimeType(mimeType);
        }

        fileMetadata.setName(name)
                .setParents(Collections.singletonList(parentFolderId))
                .setMimeType(mimeType);

        return this.driveService.files().create(fileMetadata).setFields("id").execute();
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
//                    .setQ("name='" + fileName + "'")
                    .setQ(query)
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id)")
                    .setPageToken(pageToken)
                    .execute();
            pageToken = result.getNextPageToken();
        } while (pageToken != null);

        return result.getFiles();
    }

    private class GoogleAPIService {
        private final String APPLICATION_NAME = "Music Projects Portal";
        private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        private final String TOKENS_DIRECTORY_PATH = "tokens";
        private final List<String> SCOPES = Collections.singletonList(SheetsScopes.DRIVE);
        private final String CREDENTIALS_FILE_PATH = "/credentials.json";

        public GoogleAPIService() {
        }

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


