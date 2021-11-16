import com.google.api.services.sheets.v4.model.Response;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

abstract class SheetCreator {

    private final String spreadsheetId;
    private final GoogleAPIClient service;
    private final String projectId;
    private final String sheetName;
    private final Integer dimensionIndex;
    private final TableObject table;
    private final List<List<Object>> valuesList;
    private final List<List<Object>> parsedValuesList;

    public SheetCreator(String spreadSheetId, String projectId, Integer dimensionIndex, String sheetName, TableObject table) throws GeneralSecurityException, IOException {

        this.spreadsheetId = spreadSheetId;
        this.projectId = projectId;
        this.sheetName = sheetName;
        this.service = new GoogleAPIClient();
        this.dimensionIndex = dimensionIndex;
        this.table = table;
        this.valuesList = table.initValuesList();
        this.parsedValuesList = parseList();
    }

    public List<List<Object>> parseList() throws IOException {

        List<List<Object>> newParsedValues = new ArrayList<>();
        newParsedValues.add(valuesList.get(0));
        for (int i = 1; i < valuesList.size(); i++) {
            if (valuesList.get(i).get(0).toString().contains(this.projectId)) {
                newParsedValues.add(valuesList.get(i));
            }
        }
        for (int i = 1; i < newParsedValues.size(); i++) {
            newParsedValues.get(i).remove(0);
        }
        return newParsedValues;
    }

    public Integer updateSheet() throws IOException {
        return this.service.updateSheet(spreadsheetId,sheetName + "!A1:Z100", parsedValuesList);
    }

    public void makeFirstRowBold() throws IOException {
        this.service.makeFirstRowBold(spreadsheetId, sheetName);
    }

    public void setTextWrappingClip() throws IOException {
        this.service.setTextWrappingClip(spreadsheetId, sheetName);
    }

    public void setColumnDimensionAuto() throws IOException {
        this.service.setColumnDimensionAuto(spreadsheetId, sheetName);
    }

    public String clearSheet() throws IOException {
        return this.service.clearSheet(spreadsheetId, sheetName);
    }

    public List<Response> addSheet() throws IOException {
        return service.addSheet(spreadsheetId, sheetName);
    }

    public void sortSheet() throws IOException {
        service.sortRows(spreadsheetId, sheetName, dimensionIndex);
    }

    public abstract void setColumnDimensionTo80() throws IOException;

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