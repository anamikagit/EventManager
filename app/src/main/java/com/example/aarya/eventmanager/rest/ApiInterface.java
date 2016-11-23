package com.example.aarya.eventmanager.rest;

import com.example.aarya.eventmanager.model.Guards;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("getguard")
    Call<List<Guards>> getGuardList(@Query("center_id") String apiKey);
}
