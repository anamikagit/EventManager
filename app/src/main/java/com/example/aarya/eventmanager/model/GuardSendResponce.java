package com.example.aarya.eventmanager.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuardSendResponce {
    @SerializedName("response")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
