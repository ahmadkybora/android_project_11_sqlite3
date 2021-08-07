package com.example.android_project_11_sqlite3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("me", "airportname is : ", SQLiteHelper.builder(this).getAirportName("NJF"));
    }
}