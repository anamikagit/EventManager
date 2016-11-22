package com.example.aarya.eventmanager.rest;

import com.example.aarya.eventmanager.model.Guards;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("getguard")
    Call<Guards> getGuardList(@Query("api_key") String apiKey);
}
