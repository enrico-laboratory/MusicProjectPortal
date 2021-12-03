package com.enricoruggieri.database_engine;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Build master tables
        MasterTables tables = new MasterTables();

        var musicProject = tables.getTableMusicProjects();
        var repertoireAndDivisi = tables.getTableRepertoireAndDivisi();
        var schedule = tables.getTableSchedules();
        var cast = tables.getTableCast();
        var location = tables.getTableLocation();

        List<List<Object>> scheduleValueList = ValueListsBuilder.buildScheduleValueList(
                "425799e7-6c61-4ef7-9d6e-669dcb181687",
                schedule);
        List<List<Object>> castValueList = ValueListsBuilder.buildCastValueList(
                "425799e7-6c61-4ef7-9d6e-669dcb181687",
                cast);
        List<List<Object>> repertoireValueList = ValueListsBuilder.buildRepertoireValueList(
                "425799e7-6c61-4ef7-9d6e-669dcb181687",
                repertoireAndDivisi);
        List<List<Object>> repertoireValueList2 = ValueListsBuilder.buildRepertoireValueList(
                "aeed0ea2-ed36-4e12-b17a-b1f155ecf38c",
                repertoireAndDivisi);
        List<List<Object>> divisiValueList = ValueListsBuilder.buildDivisiValueList(
                "aeed0ea2-ed36-4e12-b17a-b1f155ecf38c",
                repertoireAndDivisi);
        List<List<Object>> locationValueList = ValueListsBuilder.buildLocationValueList(
                "425799e7-6c61-4ef7-9d6e-669dcb181687",
                location, schedule);
        System.out.println("hello!");



    }
}
