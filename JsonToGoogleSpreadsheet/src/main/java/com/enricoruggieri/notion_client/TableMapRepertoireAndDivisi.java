package com.enricoruggieri.notion_client;

import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapRepertoireAndDivisi extends TableMapObject {

    public final String order;
    public final List<String> music;
    public final List<String> musicRollup;
    public final List<String> composerRollup;
    public final List<Number> lengthRollup;
    public final List<String> voicesRollup;
    public final List<String> soloRollup;
    public final List<String> instrumentRollup;
    public final String note;
    public final List<String> scoreRollup;
    public final List<String> mediaRollup;
    public final List<String> recordingRollup;
    public final List<String> musicProject;
    public final Number length;
    public final Boolean selected;
    public final String divisi1;
    public final String divisi2;
    public final String divisi3;
    public final String divisi4;
    public final String divisi5;
    public final String divisi6;
    public final String divisi7;
    public final String divisi8;
    public final String divisi9;
    public final String divisi10;
    public final String divisi11;
    public final String divisi12;

    public TableMapRepertoireAndDivisi(Page page) {
        super(page);
        this.order = NotionWrapper.getTitleValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_ORDER);
        this.music = NotionWrapper.getRelationsValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC);
        this.musicRollup = NotionWrapper.getTitleValueRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC_ROLLUP);
        this.composerRollup = NotionWrapper.getRichTextRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_COMPOSER_ROLLUP);
        this.lengthRollup = NotionWrapper.getNumberRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_LENGTH_ROLLUP);
        this.voicesRollup = NotionWrapper.getSelectRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_VOICES_ROLLUP);
        this.soloRollup = NotionWrapper.getSelectRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SOLO_ROLLUP);
        this.instrumentRollup = NotionWrapper.getMultiSelectRollupValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_INSTRUMENTS_ROLLUP);
        this.note = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_NOTE);
        this.scoreRollup = NotionWrapper.getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SCORE_ROLLUP);
        this.mediaRollup = NotionWrapper.getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MEDIA_ROLLUP);
        this.recordingRollup = NotionWrapper.getLinkRollup(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_RECORDING_ROLLUP);
        this.musicProject = NotionWrapper.getRelationsValue(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_MUSIC_PROJECT);
        this.length = NotionWrapper.getFormulaNumber(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_LENGTH);
        this.selected = NotionWrapper.getCheckbox(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_SELECTED);
        this.divisi1 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_1_TOP_VOICE);
        this.divisi2 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_2);
        this.divisi3 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_3);
        this.divisi4 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_4);
        this.divisi5 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_5);
        this.divisi6 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_6);
        this.divisi7 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_7);
        this.divisi8 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_8);
        this.divisi9 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_9);
        this.divisi10 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_10);
        this.divisi11 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_11);
        this.divisi12 = NotionWrapper.getRichText(page, Config.REPERTOIRE_AND_DIVISI_DATABASE_12);
    }

    public String getOrder() {
        return order;
    }

    public List<String> getMusic() {
        return music;
    }

    public List<String> getMusicRollup() {
        return musicRollup;
    }

    public List<String> getComposerRollup() {
        return composerRollup;
    }

    public List<Number> getLengthRollup() {
        return lengthRollup;
    }

    public List<String> getVoicesRollup() {
        return voicesRollup;
    }

    public List<String> getSoloRollup() {
        return soloRollup;
    }

    public List<String> getInstrumentRollup() {
        return instrumentRollup;
    }

    public String getNote() {
        return note;
    }

    public List<String> getScoreRollup() {
        return scoreRollup;
    }

    public List<String> getMediaRollup() {
        return mediaRollup;
    }

    public List<String> getRecordingRollup() {
        return recordingRollup;
    }

    public List<String> getMusicProject() {
        return musicProject;
    }

    public Number getLength() {
        return length;
    }

    public Boolean getSelected() {
        return selected;
    }

    public String getDivisi1() {
        return divisi1;
    }

    public String getDivisi2() {
        return divisi2;
    }

    public String getDivisi3() {
        return divisi3;
    }

    public String getDivisi4() {
        return divisi4;
    }

    public String getDivisi5() {
        return divisi5;
    }

    public String getDivisi6() {
        return divisi6;
    }

    public String getDivisi7() {
        return divisi7;
    }

    public String getDivisi8() {
        return divisi8;
    }

    public String getDivisi9() {
        return divisi9;
    }

    public String getDivisi10() {
        return divisi10;
    }

    public String getDivisi11() {
        return divisi11;
    }

    public String getDivisi12() {
        return divisi12;
    }

    @Override
    public String toString() {
        return "TableMapRepertoireAndDivisi{" +
                "order='" + order + '\'' +
                ", music=" + music +
                ", musicRollup=" + musicRollup +
                ", composerRollup=" + composerRollup +
                ", lengthRollup=" + lengthRollup +
                ", voicesRollup=" + voicesRollup +
                ", soloRollup=" + soloRollup +
                ", instrumentRollup=" + instrumentRollup +
                ", note='" + note + '\'' +
                ", scoreRollup=" + scoreRollup +
                ", mediaRollup=" + mediaRollup +
                ", recordingRollup=" + recordingRollup +
                ", musicProject=" + musicProject +
                ", length=" + length +
                ", selected=" + selected +
                ", divisi1='" + divisi1 + '\'' +
                ", divisi2='" + divisi2 + '\'' +
                ", divisi3='" + divisi3 + '\'' +
                ", divisi4='" + divisi4 + '\'' +
                ", divisi5='" + divisi5 + '\'' +
                ", divisi6='" + divisi6 + '\'' +
                ", divisi7='" + divisi7 + '\'' +
                ", divisi8='" + divisi8 + '\'' +
                ", divisi9='" + divisi9 + '\'' +
                ", divisi10='" + divisi10 + '\'' +
                ", divisi11='" + divisi11 + '\'' +
                ", divisi12='" + divisi12 + '\'' +
                '}';
    }
}
