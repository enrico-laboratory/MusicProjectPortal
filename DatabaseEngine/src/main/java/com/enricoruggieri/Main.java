package com.enricoruggieri;

import com.enricoruggieri.database_engine.Config;
import com.enricoruggieri.database_engine.MasterTables;
import com.enricoruggieri.database_engine.TableMaps.*;
import com.enricoruggieri.database_engine.to_google_sheet.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException, IOException, InterruptedException {

        // Build master tables
        List<TableMapMusicProject> musicProjectTable = MasterTables.buildTableMusicProject();
        List<TableMapRepertoireAndDivisi> repertoireAndDivisiTable = MasterTables.buildTableRepertoireAndDivisi();
        List<TableMapSchedule> scheduleTable = MasterTables.buildTableSchedule();
        List<TableMapCast> castTable = MasterTables.buildTableCast();
        List<TableMapLocation> locationTable = MasterTables.buildTableLocation();

        // List ongoing projects
        List<TableMapMusicProject> ongoingMusicProjects = new ArrayList<>();
        musicProjectTable.forEach(ongoingMusicProject -> {
                    if (!ongoingMusicProject.getCancelled() && !ongoingMusicProject.getCompleted()) {
                        ongoingMusicProjects.add(ongoingMusicProject);
                    }
                }
        );

        // Set date for logger
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        // For each ongoing project create a new spreadsheet if not existing
        for (TableMapMusicProject project : ongoingMusicProjects) {

            SpreadsheetCreator spreadsheet = new SpreadsheetCreator(
                    project.getTitle(),
                    project.getProjectId(),
                    Config.TEST_FOLDER_ID);

            System.out.println();
            System.out.println("Deleting default Sheet1...");
            spreadsheet.deleteDefaultSheet();

            // Instanciate the sheet classes

            var sheetRepertoire = new SheetRepertoire(
                    spreadsheet.getSpreadsheetId(),
                    spreadsheet.getProjectId(),
                    ValueListsBuilder.buildRepertoireValueList(
                            spreadsheet.getProjectId(),
                            repertoireAndDivisiTable
                    )
            );

            var sheetSchedule = new SheetSchedule(
                    spreadsheet.getSpreadsheetId(),
                    spreadsheet.getProjectId(),
                    ValueListsBuilder.buildScheduleValueList(
                            spreadsheet.getProjectId(),
                            scheduleTable
                    )
            );

            var sheetCast = new SheetCast(
                    spreadsheet.getSpreadsheetId(),
                    spreadsheet.getProjectId(),
                    ValueListsBuilder.buildCastValueList(
                            spreadsheet.getProjectId(),
                            castTable
                    )
            );

            var sheetDivisi= new SheetDivisi(
                    spreadsheet.getSpreadsheetId(),
                    spreadsheet.getProjectId(),
                    ValueListsBuilder.buildDivisiValueList(
                            spreadsheet.getProjectId(),
                            repertoireAndDivisiTable
                    )
            );

            var sheetLocation= new SheetLocations(
                    spreadsheet.getSpreadsheetId(),
                    spreadsheet.getProjectId(),
                    ValueListsBuilder.buildLocationValueList(
                            spreadsheet.getProjectId(),
                            locationTable,
                            scheduleTable
                    )
            );

            // Create a list which hold all the sheet instances
            List<SheetBuilder> sheetsList = new ArrayList<>();

            sheetsList.add(sheetRepertoire);
            sheetsList.add(sheetSchedule);
            sheetsList.add(sheetCast);
            sheetsList.add(sheetDivisi);
            sheetsList.add(sheetLocation);

            // Call various methods to upload sheets to spreadsheet and format them
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Updating project \"" + project.getTitle() + "\"");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

            for (SheetBuilder sheet : sheetsList) {
                System.out.println();
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
                System.out.println("Setting columns dimension...");
                sheet.setColumnDimension();
            }

            // Avoid exceeding update per minute Google API limit
            Thread.sleep(61000);
        }
    }
}
