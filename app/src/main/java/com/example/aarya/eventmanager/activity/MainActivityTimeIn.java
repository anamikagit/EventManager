package com.example.aarya.eventmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.aarya.eventmanager.R;
import com.example.aarya.eventmanager.adapter.GuardListAdapter;
import com.example.aarya.eventmanager.model.Guards;
import com.example.aarya.eventmanager.rest.ApiClient;
import com.example.aarya.eventmanager.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityTimeIn extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time_in);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Guards>> call = apiService.getGuardList("1");
        call.enqueue(new Callback<List<Guards>>() {
            @Override
            public void onResponse(Call<List<Guards>> call, Response<List<Guards>> response) {
                List<Guards> guards = response.body();
                recyclerView.setAdapter(new GuardListAdapter(guards, R.layout.guard_list_row, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Guards>> call, Throwable t) {
                Log.e(TAG, "Call failed: "+t.getMessage());
            }
        });
    }
}
