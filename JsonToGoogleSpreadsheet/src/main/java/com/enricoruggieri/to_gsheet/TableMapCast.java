package com.enricoruggieri.to_gsheet;

import com.enricoruggieri.notion_client.NotionWrapper;
import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapCast {

    private final String role;
    private final List<String> singer;
    private final List<String> singerRollup;
    private final String email;
    private final String status;
    private final String note;
    private final List<String> musicProject;
    private final String phone;

    public TableMapCast(String role,
                        List<String> singer,
                        List<String> singerRollup,
                        String email,
                        String status,
                        String note,
                        List<String> musicProject,
                        String phone)
    {
        this.role = role;
        this.singer = singer;
        this.singerRollup = singerRollup;
        this.email = email;
        this.status = status;
        this.note = note;
        this.musicProject = musicProject;
        this.phone = phone;
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
