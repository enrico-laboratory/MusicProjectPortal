package com.enricoruggieri.json_mapper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableMapLocation {

    @SerializedName("Tasks")
    List<String> tasks;
    String id;
    @SerializedName("\ufeffName")
    String name;
    @SerializedName("Address")
    String address;
    @SerializedName("City")
    String city;
}
