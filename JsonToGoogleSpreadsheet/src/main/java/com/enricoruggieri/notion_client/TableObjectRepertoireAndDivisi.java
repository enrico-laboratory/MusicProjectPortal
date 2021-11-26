package com.enricoruggieri.notion_client;

import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class TableObjectRepertoireAndDivisi extends TableObject {

    private final List<Page> repertoireAndDivisiTable;

    public TableObjectRepertoireAndDivisi(NotionClient client) {
        super(client, new NotionWrapper(client, Config.REPERTOIRE_AND_DIVISI_TABLE_ID));
        this.repertoireAndDivisiTable = getRecordParser().getDatabasePages();
    }

    @Override
    public List<TableMapRepertoireAndDivisi> buildDatabase() {
        List<TableMapRepertoireAndDivisi> table = new ArrayList<>();

        this.repertoireAndDivisiTable.forEach(page ->
                table.add(new TableMapRepertoireAndDivisi(
                        getRecordParser().getTitleValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_ORDER),
                        getRecordParser().getRelationsValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC),
                        getRecordParser().getTitleValueRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC_ROLLUP),
                        getRecordParser().getRichTextRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_COMPOSER_ROLLUP),
                        getRecordParser().getNumberRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_LENGTH_ROLLUP),
                        getRecordParser().getSelectRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_VOICES_ROLLUP),
                        getRecordParser().getSelectRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SOLO_ROLLUP),
                        getRecordParser().getMultiSelectRollupValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_INSTRUMENTS_ROLLUP),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_NOTE),
                        getRecordParser().getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SCORE_ROLLUP),
                        getRecordParser().getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MEDIA_ROLLUP),
                        getRecordParser().getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_RECORDING_ROLLUP),
                        getRecordParser().getRelationsValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC_PROJECT),
                        getRecordParser().getFormula(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_LENGTH),
                        getRecordParser().getCheckbox(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SELECTED),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_1_TOP_VOICE),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_2),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_3),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_4),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_5),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_6),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_7),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_8),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_9),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_10),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_11),
                        getRecordParser().getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_12)
                )));

        return table;
    }
}
