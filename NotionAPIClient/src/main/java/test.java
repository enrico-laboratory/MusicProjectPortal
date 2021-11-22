import notion.api.v1.NotionClient;
import notion.api.v1.model.databases.Database;
import notion.api.v1.model.databases.QueryResults;
import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageProperty;
import notion.api.v1.request.databases.QueryDatabaseRequest;

import java.io.FileNotFoundException;
import java.util.List;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        try (NotionClient client = new NotionClient(System.getenv("NOTION_TOKEN"))) {
//            List<Database> databases = client.listDatabases().getResults();

//            System.out.println("+++++++++++++++++++++++++++++++++++++++=");
            List<Page> database = client.queryDatabase(new QueryDatabaseRequest(DatabaseList.REPERTOIRE_DATABASE)).getResults();
//
            PageProperty.Rollup musicRollup = database.get(0).getProperties().get("Music Rollup").getRollup();

//            System.out.println("+++++++++++++++++++++++++++++++++++++++=");
//            System.out.println(
//                    database.get(0).getProperties().get("Order").getTitle().get(0).getPlainText() + "\n" +
//                            database.get(0).getProperties().get("Music").getRelation().get(0).getId() + "\n" +
//                            database.get(0).getProperties().get("Music Rollup").getRollup().toString() + "\n" +
//                            database.get(0).getProperties().get("Composer") + "\n" +
//                            database.get(0).getProperties().get("Length").getFormula().getNumber()
//            );
//            List<PageProperty.PageReference> tasks = database1.getResults().get(0).getProperties().get("Tasks").getRelation();
//            for (PageProperty.PageReference task :tasks) {
//                System.out.println(task.getId());
//            }
//
//            System.out.println("+++++++++++++++++++++++++++++++++++++++=");
//
//            List<Page> titles = database1.getResults();
//            for (Page title : titles) {
//                if (title.getProperties().get("Title").getTitle().get(0).getPlainText().equals("QS 2022")){
//                    System.out.println(title.getProperties().get("Choirs").getRelation());
//                }
//            }
//
//        NotionAPIClient client = new NotionAPIClient();
//
//        List<Page> repertoireDatabase = client.getDatabase(DatabaseList.REPERTOIRE_DATABASE);
//
//

//            var database = databases.getResults().get(0).;


//            System.out.println(database);


//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            JsonReader reader = new JsonReader((new FileReader("json/test.json")));
////            JsonElement jsonElement = JsonParser.parseString(reader.toString());
//            String prettyJsonString = gson.toJson(reader);
//            System.out.println(prettyJsonString);
//        }

        }
    }
}
