import com.enricoruggieri.notion_client.*;
import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;

import java.util.List;

public class NotionClientTest {

    public static void main(String[] args) {

        List<Page> locationTable = new Query().getLocationTable();

        for (Page page : locationTable) {
            TableMapLocation record = new TableMapLocation(page);
            System.out.println(record);
        }


    }
}
