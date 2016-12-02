package com.example.aarya.eventmanager.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import com.example.aarya.eventmanager.R;
import com.example.aarya.eventmanager.model.Center;
import com.example.aarya.eventmanager.model.Guard;
import com.example.aarya.eventmanager.rest.ApiClient;
import com.example.aarya.eventmanager.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CenterDetail extends AppCompatActivity {

    TextView centerId, centerName;
    //List<Guard> guards = new List<Guard>();

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String deviceNum;
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        deviceNum = telephonyManager.getDeviceId();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_detail);
        centerId = (TextView) findViewById(R.id.center_id);
        centerName = (TextView) findViewById(R.id.center_name);
        //List<Guard> guardList = new ArrayList<Guard>();//

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Center>> call = apiService.getCenterDetail(deviceNum);
        call.enqueue(new Callback<List<Center>>() {
            @Override
            public void onResponse(Call<List<Center>> call, Response<List<Center>> response) {
                List<Center> centers = response.body();
                centerId.setText(centers.get(0).getCenterId());
                centerName.setText(centers.get(0).getCenterName());

            }

            @Override
            public void onFailure(Call<List<Center>> call, Throwable t) {
                Log.e(TAG, "Call failed: " + t.getMessage());
            }
        });

    }
}
