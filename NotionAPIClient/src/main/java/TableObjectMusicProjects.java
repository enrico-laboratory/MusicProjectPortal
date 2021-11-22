import notion.api.v1.model.databases.Database;

import java.util.List;

public class TableObjectMusicProjects {

    private final List<Database> databaseList;

    public TableObjectMusicProjects(List<Database> databaseList) {
        this.databaseList = databaseList;
    }

}
