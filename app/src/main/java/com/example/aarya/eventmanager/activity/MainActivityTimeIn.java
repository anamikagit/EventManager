package com.example.aarya.eventmanager.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.example.aarya.eventmanager.R;
import com.example.aarya.eventmanager.adapter.GuardListAdapter;
import com.example.aarya.eventmanager.model.Guards;
import com.example.aarya.eventmanager.rest.ApiClient;
import com.example.aarya.eventmanager.rest.ApiInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

        // display IMEI num and date time(24-nov-2016)
        String deviceNum;
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        deviceNum = telephonyManager.getDeviceId();
        //String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        String strDate = sdf.format(c.getTime());
        Toast.makeText(MainActivityTimeIn.this, deviceNum+" "+strDate,Toast.LENGTH_LONG).show();
        //Recycler View
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
                Log.e(TAG, "Call failed: " + t.getMessage());
            }
        });

    }
}
