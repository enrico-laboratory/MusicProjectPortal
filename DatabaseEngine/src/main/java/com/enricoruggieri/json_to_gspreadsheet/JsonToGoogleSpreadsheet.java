package com.enricoruggieri.json_to_gspreadsheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Calendar;
import java.util.List;

public class JsonToGoogleSpreadsheet {

    public static void main(String... args) throws GeneralSecurityException, IOException, InterruptedException {

        List<TableMusicProjects.TableMusicProjectsMap> tableMusicProjectsNotCompleted = new TableMusicProjects().isNotCompleted();
        for (TableMusicProjects.TableMusicProjectsMap table : tableMusicProjectsNotCompleted ) {
            String projectId = table.getId();
            String projectTitle = table.getTitle();

            SpreadsheetCreator spreadsheet = new SpreadsheetCreator(
                    projectTitle,
                    projectId
            );
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar.getTime());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Updating project \"" + projectTitle + "\"");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

            spreadsheet.deleteDefaultSheet();
            spreadsheet.populateSheets();

            // Avoiding GoogleSheet limit update per minute
            Thread.sleep(61000);
        }
    }
}
