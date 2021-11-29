import com.enricoruggieri.json_mapper.*;

import java.io.FileNotFoundException;
import java.util.List;

public class JsonMapperTest {
    public static void main(String[] args) throws FileNotFoundException {
        List<TableMapMusicProjects> musicProjectsTable = new TableObjectMusicProject().getTableObjectList();
        List<TableMapRepertoireAndDivisi> repertoireAndDivisiTable = new TableObjectRepertoireAndDvisi().getTableObjectList();
        List<TableMapSchedule> scheduleTable = new TableObjectSchedule().getTableObjectList();
        List<TableMapCast> castTable = new TableObjectCast().getTableObjectList();
        List<TableMapLocation> locationsTable = new TableObjectLocation().getTableObjectList();

        System.out.println(repertoireAndDivisiTable);


    }
}
