package com.example.aarya.eventmanager.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Guards {

    @SerializedName("guard_id")
    @Expose
    private String guardId;
    @SerializedName("token_no")
    @Expose
    private String tokenNo;
    @SerializedName("name")
    @Expose
    private String name;

    public String getGuardId() {
        return guardId;
    }

    public void setGuardId(String guardId) {
        this.guardId = guardId;
    }

    public String getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
