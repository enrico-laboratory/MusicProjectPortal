package com.enricoruggieri.notion_client;

import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapCast extends TableMapObject {

    private final String role;
    private final List<String> singer;
    private final List<String> singerRollup;
    private final String email;
    private final String status;
    private final String note;
    private final List<String> musicProject;
    private final String phone;

    public TableMapCast(Page page) {
        super(page);
        this.role = NotionWrapper.getTitleValue(page, Config.CAST_TABLE_ROLE);
        this.singer = NotionWrapper.getRelationsValue(page, Config.CAST_TABLE_SINGER);
        this.singerRollup = NotionWrapper.getTitleValueRollup(page, Config.CAST_TABLE_SINGER_ROLLUP);
        this.email = NotionWrapper.getEmailRollup(page, Config.CAST_TABLE_EMAIL);
        this.status = NotionWrapper.getSelect(page, Config.CAST_TABLE_STATUS);
        this.note = NotionWrapper.getRichText(page, Config.CAST_TABLE_NOTE);
        this.musicProject = NotionWrapper.getRelationsValue(page, Config.CAST_TABLE_MUSIC_PROJECT);
        this.phone = NotionWrapper.getPhoneRollup(page, Config.CAST_TABLE_PHONE);
    }

    public String getRole() {
        return role;
    }

    public List<String> getSinger() {
        return singer;
    }

    public List<String> getSingerRollup() {
        return singerRollup;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public List<String> getMusicProject() {
        return musicProject;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "TableMapCast{" +
                "role='" + role + '\'' +
                ", singer=" + singer +
                ", singerRollup=" + singerRollup +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", musicProject=" + musicProject +
                ", phone='" + phone + '\'' +
                '}';
    }
}
