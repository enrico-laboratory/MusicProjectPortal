import java.io.IOException;
import java.security.GeneralSecurityException;
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
            System.out.println("Updating project \"" + projectTitle + "\"");
            System.out.println();
            spreadsheet.deleteDefaultSheet();
            spreadsheet.populateSheets();

            // Avoiding GoogleSheet limit update per minute
            Thread.sleep(61000);
        }
    }
}
