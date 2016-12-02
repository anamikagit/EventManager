package com.example.aarya.eventmanager.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Guard {

    @SerializedName("guard_id")
    private String guardId;

    @SerializedName("token_no")
    private String tokenNo;

   /* @SerializedName("name")
    private String name;*/

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

    @SerializedName("Replacement")
    private String replacement;


    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    private boolean isGuardSelected;

    public boolean isGuardSelected() {
        return isGuardSelected;
    }

    public void setGuardSelected(boolean guardSelected) {
        isGuardSelected = guardSelected;
    }

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

   /* public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

}
