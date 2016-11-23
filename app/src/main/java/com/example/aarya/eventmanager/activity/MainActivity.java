package com.example.aarya.eventmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aarya.eventmanager.R;

public class MainActivity extends AppCompatActivity {
    Button timeIn;
    Button timeOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeIn= (Button) findViewById(R.id.time_in);
        timeOut= (Button) findViewById(R.id.time_out);

        timeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivityTimeIn.class);
                startActivity(i);
            }
        });
    }
}
