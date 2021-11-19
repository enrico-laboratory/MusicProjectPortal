import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class SpreadsheetCreator {

    private final String spreadsheetId;
    private final String spreadsheetTitle;
    private final String projectId;
    private final GoogleAPIClient service;
    private final SheetRepertoire sheetRepertoire;
    private final SheetSchedule sheetSchedule;
    private final SheetCast sheetCast;
    private final SheetDivisi sheetDivisi;
    private final SheetLocations sheetLocations;

    public SpreadsheetCreator(String spreadsheetTitle, String projectId) throws IOException, GeneralSecurityException {
        this.spreadsheetTitle = spreadsheetTitle;
        this.projectId = projectId;
        this.service = new GoogleAPIClient();
        this.spreadsheetId = setSpreadSheetId();
        this.sheetRepertoire = new SheetRepertoire(this.spreadsheetId,this.projectId);
        this.sheetSchedule = new SheetSchedule(this.spreadsheetId,this.projectId);
        this.sheetCast = new SheetCast(this.spreadsheetId,this.projectId);
        this.sheetDivisi = new SheetDivisi(this.spreadsheetId,this.projectId);
        this.sheetLocations = new SheetLocations(this.spreadsheetId,this.projectId);
    }

    private String setSpreadSheetId() throws IOException {
        String MAIN_FOLDER_ID = "1ggP6aU93RJT1HzgigtzIA6YLeMWAJtKD";
        if (service.searchFileInFolder(this.spreadsheetTitle, MAIN_FOLDER_ID).isEmpty()) {
            return service.createSpreadSheet(this.spreadsheetTitle, MAIN_FOLDER_ID).getId();
        }
        return service.getFileId(this.spreadsheetTitle, MAIN_FOLDER_ID);
    }

    public void populateSheets() throws IOException {
        List<SheetCreator> sheetsList = new ArrayList<>();
        sheetsList.add(sheetRepertoire);
        sheetsList.add(sheetSchedule);
        sheetsList.add(sheetCast);
        sheetsList.add(sheetDivisi);
        sheetsList.add(sheetLocations);

        for (SheetCreator sheet : sheetsList) {
            System.out.println();
            System.out.println("Updating sheet: " + sheet.getSheetName().toUpperCase());
            populateSheet(sheet);
        }
    }

    private void populateSheet(SheetCreator sheet) throws IOException {
        try {
            System.out.println("Creating sheets: " + sheet.addSheet());
        } catch (NullPointerException e) {
            System.out.println("Sheet already exists!");
        }

        System.out.println("Clearing Sheet: " + sheet.clearSheet());

        System.out.println("Getting updated cells :" + sheet.updateSheet());
        System.out.println("Making first row bold...");
        sheet.makeFirstRowBold();
        System.out.println("Sorting sheet...");
        sheet.sortSheet();
        System.out.println("Setting column dimension to auto...");
        sheet.setColumnDimensionAuto();
        sheet.changeDateFormat();
        System.out.println("Setting text wrapping to clip...");
        sheet.setTextWrappingClip();
        sheet.setColumnDimensionTo80();
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
