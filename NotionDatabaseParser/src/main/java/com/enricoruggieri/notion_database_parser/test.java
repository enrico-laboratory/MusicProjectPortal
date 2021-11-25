package com.enricoruggieri.notion_database_parser;

import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;

import java.util.List;

public class test {

    public static void main(String[] args) {
        try (NotionClient client = new NotionClient(System.getenv("NOTION_TOKEN"))) {
//            List<Page> database = client.queryDatabase(new QueryDatabaseRequest(DatabaseList.REPERTOIRE_DATABASE)).getResults();
//            RecordParser repertoireDatabase = new RecordParser(client, DatabaseList.REPERTOIRE_DATABASE);
//            List<Page> repertoireDatabasePages = repertoireDatabase.getDatabasePages();

            List<RecordFields> databaseRepertoire = new DatabaseRepertoire(client).buildDatabase();
            System.out.println(databaseRepertoire);
            //            for (Page page : repertoireDatabasePages) {
//
//                System.out.print(repertoireDatabase.getTitleValue(page, "Order") + " ");
//                System.out.print(repertoireDatabase.getRelationsValue(page, "Music"));
//                System.out.print(repertoireDatabase.getTitleValueRollup(page, "Music Rollup") + " / ");
//                System.out.print(repertoireDatabase.getRichTextRollup(page, "Composer") + " / ");
//                System.out.print(repertoireDatabase.getNumberRollup(page, "Length Rollup") + " / ");
//                System.out.print(repertoireDatabase.getSelectRollup(page, "Voices") + " / ");
//                System.out.print(repertoireDatabase.getSelectRollup(page, "Solo") + " / ");
//                System.out.print(repertoireDatabase.getMultiSelectRollupValue(page, DatabaseList.REPERTOIRE_DATABASE_INSTRUMENTS_ROLLUP) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_NOTE) + " / ");
//                System.out.print(repertoireDatabase.getLinkRollup(page, DatabaseList.REPERTOIRE_DATABASE_SCORE_ROLLUP) + " / ");
//                System.out.print(repertoireDatabase.getLinkRollup(page, DatabaseList.REPERTOIRE_DATABASE_MEDIA_ROLLUP) + " / ");
//                System.out.print(repertoireDatabase.getLinkRollup(page, DatabaseList.REPERTOIRE_DATABASE_RECORDING_ROLLUP) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_1_TOP_VOICE) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_2) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_3) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_4) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_5) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_6) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_7) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_8) + " / ");
//                System.out.print(repertoireDatabase.getRichText(page, DatabaseList.REPERTOIRE_DATABASE_9) + " / ");
//
//
//                System.out.println();
//            }
//
//
//        }

//            List<Database> databases = client.listDatabases().getResults();

//            System.out.println("+++++++++++++++++++++++++++++++++++++++=");
//            List<Page> database = new NotionGetters(DatabaseList.REPERTOIRE_DATABASE).queryDatabase();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++=");
//            for (Page page : database) {
//                System.out.println(NotionGetters.getTitleValue(page, "Order"));
//            }

//            String musicRollup = database.get(0).getProperties().get("Music Rollup").getRollup().getArray().get(0).getTitle().get(0).getPlainText();
//            System.out.println(musicRollup);
//
//            System.out.println("+++++++++++++++++++++++++++++++++++++++=");
//            System.out.println(
//                    database.get(1).getProperties().get("Order")
//                            .getTitle().get(0).getPlainText() + "\n" +
//                    database.get(1).getProperties().get("Music")
//                            .getRelation().get(0).getId() + "\n" +
//                    database.get(1).getProperties().get("Music Rollup")
//                            .getRollup().getArray().get(0).getTitle().get(0).getPlainText() + "\n" +
//                    database.get(1).getProperties().get("Composer")
//                            .getRollup().getArray().get(0).getRichText().get(0).getPlainText() + "\n" +
//                    database.get(1).getProperties().get("Length")
//                            .getFormula().getNumber()  + "\n" +
//                    database.get(1).getProperties().get("Voices")
//                            .getRollup().getArray().get(0).getSelect().getName()
//            );
//            List<Page> database2 = client.queryDatabase(new QueryDatabaseRequest(DatabaseList.MUSIC_PROJECT_DATABASE)).getResults();
//            System.out.println("+++++++++++++++++++++++++++++++++++++++=");
//            System.out.println(
//                    database2.get(1).getProperties().get("Title")
//                            .getTitle().get(0).getPlainText() + "\n" +
//                    database2.get(1).getProperties().get("Completed")
//                            .getCheckbox() + "\n");
//            if ((database2.get(1).getProperties().get("Start Date")
//                    .getDate()) == null) {
//                System.out.println("\n");
//            } else {
//                System.out.println(database2.get(1).getProperties().get("Start Date")
//                        .getDate().getStart());
//            }
//
//            for (int i=0; i < database2.get(1).getProperties().get("Tasks Rollup").getRollup().getArray().size(); i++) {
//                System.out.println(
//                        database2.get(1).getProperties().get("Tasks Rollup")
//                                .getRollup().getArray().get(i).getTitle().get(0).getPlainText() + "\n"
//                                database2.get(1).getProperties().get("Length")
//                                        .getFormula().getNumber() + "\n" +
//                                database2.get(1).getProperties().get("Voices")
//                                        .getRollup().getArray().get(0).getSelect().getName()
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
        }

    }
}
