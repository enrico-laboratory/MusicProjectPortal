package com.enricoruggieri.database_engine.TableMaps;

import java.util.List;

public class TableMapLocation {

    private final String location;
    private final String city;
    private final String address;
    private final List<String> purpose;
    private final List<String> contact;
    private final String email;

    public TableMapLocation(String location,
                            String city,
                            String address,
                            List<String> purpose,
                            List<String> contact,
                            String email)
    {
        this.location = location;
        this.city = city;
        this.address = address;
        this.purpose = purpose;
        this.contact = contact;
        this.email = email;
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
