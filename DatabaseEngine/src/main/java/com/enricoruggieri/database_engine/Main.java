package com.enricoruggieri.database_engine;

import com.enricoruggieri.database_engine.to_google_sheet.*;
import com.google.api.services.sheets.v4.model.Sheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException, IOException {

        // Build master tables

        var musicProjectTable = MasterTables.buildTableMusicProject();
        var repertoireAndDivisiTable = MasterTables.buildTableRepertoireAndDivisi();
        var scheduleTable = MasterTables.buildTableSchedule();
        var castTable = MasterTables.buildTableCast();
        var locationTable = MasterTables.buildTableLocation();
//
//        List<List<Object>> scheduleValueList = ValueListsBuilder.buildScheduleValueList(
//                "425799e7-6c61-4ef7-9d6e-669dcb181687",
//                schedule);
//        List<List<Object>> castValueList = ValueListsBuilder.buildCastValueList(
//                "425799e7-6c61-4ef7-9d6e-669dcb181687",
//                cast);
//        List<List<Object>> repertoireValueList = ValueListsBuilder.buildRepertoireValueList(
//                "425799e7-6c61-4ef7-9d6e-669dcb181687",
//                repertoireAndDivisi);
//        List<List<Object>> repertoireValueList2 = ValueListsBuilder.buildRepertoireValueList(
//                "aeed0ea2-ed36-4e12-b17a-b1f155ecf38c",
//                repertoireAndDivisi);
//        List<List<Object>> divisiValueList = ValueListsBuilder.buildDivisiValueList(
//                "aeed0ea2-ed36-4e12-b17a-b1f155ecf38c",
//                repertoireAndDivisi);
//        List<List<Object>> locationValueList = ValueListsBuilder.buildLocationValueList(
//                "425799e7-6c61-4ef7-9d6e-669dcb181687",
//                location, schedule);

        SpreadsheetCreator spreadSheet = new SpreadsheetCreator(
                "Jubilee 2020",
                "aeed0ea2-ed36-4e12-b17a-b1f155ecf38c",
                Config.TEST_FOLDER_ID);

        List<SheetBuilder> sheetsList = new ArrayList<>();

        var sheetRepertoire = new SheetRepertoire(
                        spreadSheet.getSpreadsheetId(),
                        spreadSheet.getProjectId(),
                        ValueListsBuilder.buildRepertoireValueList(
                                spreadSheet.getProjectId(),
                                repertoireAndDivisiTable
                        )
        );

        var sheetSchedule = new SheetSchedule(
                spreadSheet.getSpreadsheetId(),
                spreadSheet.getProjectId(),
                ValueListsBuilder.buildScheduleValueList(
                        spreadSheet.getProjectId(),
                        scheduleTable
                )
        );

        var sheetCast = new SheetCast(
                spreadSheet.getSpreadsheetId(),
                spreadSheet.getProjectId(),
                ValueListsBuilder.buildCastValueList(
                        spreadSheet.getProjectId(),
                        castTable
                )
        );

        var sheetDivisi= new SheetDivisi(
                spreadSheet.getSpreadsheetId(),
                spreadSheet.getProjectId(),
                ValueListsBuilder.buildDivisiValueList(
                        spreadSheet.getProjectId(),
                        repertoireAndDivisiTable
                )
        );

        var sheetLocation= new SheetLocations(
                spreadSheet.getSpreadsheetId(),
                spreadSheet.getProjectId(),
                ValueListsBuilder.buildLocationValueList(
                        spreadSheet.getProjectId(),
                        locationTable,
                        scheduleTable
                )
        );

        sheetsList.add(sheetRepertoire);
        sheetsList.add(sheetSchedule);
        sheetsList.add(sheetCast);
        sheetsList.add(sheetDivisi);
        sheetsList.add(sheetLocation);

        for (SheetBuilder sheet : sheetsList) {
            System.out.println("Updating sheet: " + sheet.getSheetName().toUpperCase());
            try {
                System.out.println("Creating sheets: " + sheet.addSheet());
            } catch (NullPointerException e) {
                System.out.println("Sheet already exists!");
            }

            System.out.println("Clearing Sheet: " + sheet.clearSheet());

            System.out.println("Getting updated cells :" + sheet.updateSheet());
            System.out.println("Making first row bold...");
            System.out.println(sheet.makeFirstRowBold());
            System.out.println("Sorting sheet...");
            System.out.println(sheet.sortSheet());
            System.out.println("Setting column dimension to auto...");
            System.out.println(sheet.setColumnDimensionAuto());
            System.out.println("Changing date format...");
            System.out.println(sheet.changeDateFormat());
            System.out.println("Setting text wrapping to clip...");
            System.out.println(sheet.setTextWrappingClip());
            sheet.setColumnDimension();
        }

        System.out.println("hello!");
    }
}
