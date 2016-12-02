package com.example.aarya.eventmanager.model;

import com.google.gson.annotations.SerializedName;

public class Center {

    @SerializedName("center_id")
    private String centerId;

    @SerializedName("name")
    private String centerName;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
}
