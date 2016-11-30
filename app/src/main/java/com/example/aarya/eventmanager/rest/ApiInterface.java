package com.example.aarya.eventmanager.rest;

import com.example.aarya.eventmanager.model.GuardSendResponce;
import com.example.aarya.eventmanager.model.Guard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("getguard")
    Call<List<Guard>> getGuardList(@Query("imei") String apiKey);

    @GET("getguardrepdata")
    Call<List<Guard>> getPunchedGuardList(@Query("date") String apiKey);

    @GET("getcenter")
    Call<List<Guard>> getCenterDetail(@Query("imei") String apiKey);

    @GET("insertgaurd")
    Call<List<GuardSendResponce>> sendGuardAttendence(@Query("grdid") String guardId,
                                                               @Query("gaurd_name") String guardName,
                                                               @Query("dttm") String dateTime,
                                                               @Query("imei") String imei,
                                                               @Query("rep_flag") boolean repFlag);

}
//http://111.118.178.163/sgm_android/WebService.asmx/getguard?imei=@parameter

