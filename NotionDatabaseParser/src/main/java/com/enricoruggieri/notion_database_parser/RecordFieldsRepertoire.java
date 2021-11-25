package com.enricoruggieri.notion_database_parser;

import java.util.List;

public class RecordFieldsRepertoire extends RecordFields {

    public final String order;
    public final List<String> music;
    public final String musicRollup;
    public final String composerRollup;
    public final Number lengthRollup;
    public final String voices;
    public final String solo;
    public final List<String> instrumentRollup;
    public final String note;
    public final String scoreRollup;
    public final String mediaRollup;
    public final String recordingRollup;
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

    public RecordFieldsRepertoire(String order,
                                  List<String> music,
                                  String musicRollup,
                                  String composerRollup,
                                  Number lengthRollup,
                                  String voices,
                                  String solo,
                                  List<String> instrumentRollup,
                                  String note,
                                  String scoreRollup,
                                  String mediaRollup,
                                  String recordingRollup,
                                  List<String> musicProject,
                                  Number length,
                                  Boolean selected,
                                  String divisi1,
                                  String divisi2,
                                  String divisi3,
                                  String divisi4,
                                  String divisi5,
                                  String divisi6,
                                  String divisi7,
                                  String divisi8,
                                  String divisi9,
                                  String divisi10,
                                  String divisi11,
                                  String divisi12)
    {
        this.order = order;
        this.music = music;
        this.musicRollup = musicRollup;
        this.composerRollup = composerRollup;
        this.lengthRollup = lengthRollup;
        this.voices = voices;
        this.solo = solo;
        this.instrumentRollup = instrumentRollup;
        this.note = note;
        this.scoreRollup = scoreRollup;
        this.mediaRollup = mediaRollup;
        this.recordingRollup = recordingRollup;
        this.musicProject = musicProject;
        this.length = length;
        this.selected = selected;
        this.divisi1 = divisi1;
        this.divisi2 = divisi2;
        this.divisi3 = divisi3;
        this.divisi4 = divisi4;
        this.divisi5 = divisi5;
        this.divisi6 = divisi6;
        this.divisi7 = divisi7;
        this.divisi8 = divisi8;
        this.divisi9 = divisi9;
        this.divisi10 = divisi10;
        this.divisi11 = divisi11;
        this.divisi12 = divisi12;
    }

    public String getOrder() {
        return order;
    }

    public List<String> getMusic() {
        return music;
    }

    public String getMusicRollup() {
        return musicRollup;
    }

    public String getComposerRollup() {
        return composerRollup;
    }

    public Number getLengthRollup() {
        return lengthRollup;
    }

    public String getVoices() {
        return voices;
    }

    public String getSolo() {
        return solo;
    }

    public List<String> getInstrumentRollup() {
        return instrumentRollup;
    }

    public String getNote() {
        return note;
    }

    public String getScoreRollup() {
        return scoreRollup;
    }

    public String getMediaRollup() {
        return mediaRollup;
    }

    public String getRecordingRollup() {
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
}
