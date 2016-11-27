package com.example.aarya.eventmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.aarya.eventmanager.R;
import com.example.aarya.eventmanager.adapter.GuardListAdapter;
import com.example.aarya.eventmanager.model.Guard;
import com.example.aarya.eventmanager.rest.ApiClient;
import com.example.aarya.eventmanager.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityTimeOut extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time_out);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Guard>> call = apiService.getPunchedGuardList("2016-11-26");
        call.enqueue(new Callback<List<Guard>>() {
            @Override
            public void onResponse(Call<List<Guard>> call, Response<List<Guard>> response) {
                List<Guard> guards = response.body();
                recyclerView.setAdapter(new GuardListAdapter(guards, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Guard>> call, Throwable t) {
                Log.e(TAG, "Call failed: " + t.getMessage());
            }
        });

    }
}
