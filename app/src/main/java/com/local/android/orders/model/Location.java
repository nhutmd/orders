package com.local.android.orders.model;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("status")
    private Boolean status;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
