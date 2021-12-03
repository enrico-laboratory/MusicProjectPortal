package com.enricoruggieri.database_engine;

import com.enricoruggieri.notion_client.NotionWrapper;
import com.enricoruggieri.database_engine.TableMaps.*;
import notion.api.v1.model.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class MasterTables {

    public static List<TableMapMusicProject> buildTableMusicProject() {
        List<Page> query = new Query().getMusicProjectTable();
        List<TableMapMusicProject> table = new ArrayList<>();
        for (Page page : query) {
            table.add(new TableMapMusicProject(
                            NotionWrapper.getId(page, Config.MUSIC_PROJECT_ID),
                            NotionWrapper.getTitleValue(page, Config.MUSIC_PROJECT_TITLE),
                            NotionWrapper.getCheckbox(page, Config.MUSIC_PROJECT_COMPLETED),
                            NotionWrapper.getCheckbox(page, Config.MUSIC_PROJECT_CANCELLED),
                            NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_CHOIR),
                            NotionWrapper.getTitleValueRollup(page, Config.MUSIC_PROJECT_CHOIR_ROLLUP),
                            NotionWrapper.getRichText(page, Config.MUSIC_PROJECT_DESCRIPTION),
                            NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_TASK),
                            NotionWrapper.getTitleValueRollup(page, Config.MUSIC_PROJECT_TASKS_ROLLUP),
                            NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_CAST),
                            NotionWrapper.getRelationsValue(page, Config.MUSIC_PROJECT_REPERTOIRE)
                    )
            );
        }
        return table;
    }

    public static List<TableMapRepertoireAndDivisi> buildTableRepertoireAndDivisi() {
        List<Page> query = new Query().getRepertoireandDivisiTable();
        List<TableMapRepertoireAndDivisi> table = new ArrayList<>();
        for (Page page : query) {
            table.add(new TableMapRepertoireAndDivisi(
                            NotionWrapper.getTitleValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_ORDER),
                            NotionWrapper.getRelationsValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC),
                            NotionWrapper.getTitleValueRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC_ROLLUP),
                            NotionWrapper.getRichTextRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_COMPOSER_ROLLUP),
                            NotionWrapper.getNumberRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_LENGTH_ROLLUP),
                            NotionWrapper.getSelectRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_VOICES_ROLLUP),
                            NotionWrapper.getSelectRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SOLO_ROLLUP),
                            NotionWrapper.getMultiSelectRollupValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_INSTRUMENTS_ROLLUP),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_NOTE),
                            NotionWrapper.getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SCORE_ROLLUP),
                            NotionWrapper.getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MEDIA_ROLLUP),
                            NotionWrapper.getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_RECORDING_ROLLUP),
                            NotionWrapper.getRelationsValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC_PROJECT),
                            NotionWrapper.getFormulaNumber(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_LENGTH),
                            NotionWrapper.getCheckbox(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SELECTED),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_1_TOP_VOICE),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_2),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_3),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_4),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_5),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_6),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_7),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_8),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_9),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_10),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_11),
                            NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_12)
                    )
            );
        }
        return table;
    }

    public static List<TableMapSchedule> buildTableSchedule() {
        List<Page> query = new Query().getScheduleTable();
        List<TableMapSchedule> table = new ArrayList<>();
        for (Page page : query) {
            table.add(new TableMapSchedule(
                            NotionWrapper.getTitleValue(page, Config.SCHEDULE_TABLE_TASK),
                            NotionWrapper.getSelect(page, Config.SCHEDULE_TABLE_TYPE),
                            NotionWrapper.getDate(page, Config.SCHEDULE_TABLE_DO_DATE).get(0),
                            NotionWrapper.getDate(page, Config.SCHEDULE_TABLE_DO_DATE).get(1),
                            NotionWrapper.getRelationsValue(page, Config.SCHEDULE_TABLE_MUSIC_PROJECT),
                            NotionWrapper.getTitleValueRollup(page, Config.SCHEDULE_TABLE_LOCATION_ROLLUP),
                            NotionWrapper.getFormulaString(page, Config.SCHEDULE_TABLE_DURATION),
//                            NotionWrapper.getTitleValueRollup(page, Config.SCHEDULE_TABLE_CHOIR_ROLLUP),
                            NotionWrapper.getRelationsValue(page, Config.SCHEDULE_TABLE_LOCATION)
                    )
            );
        }
        return table;
    }

    public static List<TableMapCast> buildTableCast() {
        List<Page> query = new Query().getCastTable();
        List<TableMapCast> table = new ArrayList<>();
        for (Page page : query) {
            table.add(new TableMapCast(
                            NotionWrapper.getTitleValue(page, Config.CAST_TABLE_ROLE),
                            NotionWrapper.getRelationsValue(page, Config.CAST_TABLE_SINGER),
                            NotionWrapper.getTitleValueRollup(page, Config.CAST_TABLE_SINGER_ROLLUP),
                            NotionWrapper.getEmailRollup(page, Config.CAST_TABLE_EMAIL),
                            NotionWrapper.getSelect(page, Config.CAST_TABLE_STATUS),
                            NotionWrapper.getRichText(page, Config.CAST_TABLE_NOTE),
                            NotionWrapper.getRelationsValue(page, Config.CAST_TABLE_MUSIC_PROJECT),
                            NotionWrapper.getPhoneRollup(page, Config.CAST_TABLE_PHONE)
                    )
            );
        }
        return table;
    }

    public static List<TableMapLocation> buildTableLocation() {
        List<Page> query = new Query().getLocationTable();
        List<TableMapLocation> table = new ArrayList<>();
        for (Page page : query) {
            table.add(new TableMapLocation(
                            NotionWrapper.getTitleValue(page, Config.LOCATION_TABLE_LOCATION),
                            NotionWrapper.getRichText(page, Config.LOCATION_TABLE_CITY),
                            NotionWrapper.getRichText(page, Config.LOCATION_TABLE_ADDRESS),
                            NotionWrapper.getMultiSelectValue(page, Config.LOCATION_TABLE_PURPOSE),
                            NotionWrapper.getRelationsValue(page, Config.LOCATION_TABLE_CONTACT),
                            NotionWrapper.getEmailRollup(page, Config.LOCATION_TABLE_EMAIL)
                    )
            );
        }
        return table;
    }

}
