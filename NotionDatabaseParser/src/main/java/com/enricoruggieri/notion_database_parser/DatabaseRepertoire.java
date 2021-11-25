package com.enricoruggieri.notion_database_parser;

import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DatabaseRepertoire extends DatabaseObject {

    private final List<Page> repertoireDatabasePages;

    public DatabaseRepertoire(NotionClient client) {
        super(client, new RecordParser(client, DatabaseList.REPERTOIRE_DATABASE));
        this.repertoireDatabasePages = getRecordParser().getDatabasePages();
    }

    @Override
    public List<RecordFields> buildDatabase() {
        List<RecordFields> database = new ArrayList<>();

        this.repertoireDatabasePages.forEach(page ->
                database.add(new RecordFieldsRepertoire(
                        getRecordParser().getTitleValue(page, DatabaseList.REPERTOIRE_DATABASE_ORDER),
                        getRecordParser().getRelationsValue(page, DatabaseList.REPERTOIRE_DATABASE_MUSIC),
                        getRecordParser().getTitleValueRollup(page, DatabaseList.REPERTOIRE_DATABASE_MUSIC_ROLLUP),
                        getRecordParser().getRichTextRollup(page, DatabaseList.REPERTOIRE_DATABASE_COMPOSER_ROLLUP),
                        getRecordParser().getNumberRollup(page, DatabaseList.REPERTOIRE_DATABASE_LENGTH_ROLLUP),
                        getRecordParser().getSelectRollup(page, DatabaseList.REPERTOIRE_DATABASE_VOICES_ROLLUP),
                        getRecordParser().getSelectRollup(page, DatabaseList.REPERTOIRE_DATABASE_SOLO_ROLLUP),
                        getRecordParser().getMultiSelectRollupValue(page, DatabaseList.REPERTOIRE_DATABASE_INSTRUMENTS_ROLLUP),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_NOTE),
                        getRecordParser().getLinkRollup(page, DatabaseList.REPERTOIRE_DATABASE_SCORE_ROLLUP),
                        getRecordParser().getLinkRollup(page, DatabaseList.REPERTOIRE_DATABASE_MEDIA_ROLLUP),
                        getRecordParser().getLinkRollup(page, DatabaseList.REPERTOIRE_DATABASE_RECORDING_ROLLUP),
                        getRecordParser().getRelationsValue(page, DatabaseList.REPERTOIRE_DATABASE_MUSIC_PROJECT),
                        getRecordParser().getFormula(page, DatabaseList.REPERTOIRE_DATABASE_LENGTH),
                        getRecordParser().getCheckbox(page, DatabaseList.REPERTOIRE_DATABASE_SELECTED),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_1_TOP_VOICE),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_2),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_3),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_4),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_5),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_6),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_7),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_8),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_9),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_10),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_11),
                        getRecordParser().getRichText(page, DatabaseList.REPERTOIRE_DATABASE_12)
                )));

        return database;
    }
}
