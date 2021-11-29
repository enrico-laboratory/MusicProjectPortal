package com.enricoruggieri.notion_client;

import notion.api.v1.model.pages.Page;

import java.util.List;

public class TableMapLocation extends TableMapObject {

    private final String location;
    private final String city;
    private final String address;
    private final List<String> purpose;
    private final List<String> contact;
    private final String email;

    public TableMapLocation(Page page) {
        super(page);
        this.location = NotionWrapper.getTitleValue(page, Config.LOCATION_TABLE_LOCATION);
        this.city = NotionWrapper.getRichText(page, Config.LOCATION_TABLE_CITY);
        this.address = NotionWrapper.getRichText(page, Config.LOCATION_TABLE_ADDRESS);
        this.purpose = NotionWrapper.getMultiSelectValue(page, Config.LOCATION_TABLE_PURPOSE);
        this.contact = NotionWrapper.getRelationsValue(page, Config.LOCATION_TABLE_CONTACT);
        this.email = NotionWrapper.getEmailRollup(page, Config.LOCATION_TABLE_EMAIL);
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getPurpose() {
        return purpose;
    }

    public List<String> getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "TableMapLocation{" +
                "location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", purpose=" + purpose +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                '}';
    }
}
