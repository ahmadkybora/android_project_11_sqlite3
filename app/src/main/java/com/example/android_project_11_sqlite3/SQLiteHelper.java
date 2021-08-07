package com.example.android_project_11_sqlite3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android_project_11_sqlite3.sqliteasset.SQLiteAssetHelper;

public class SQLiteHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;
    private static SQLiteHelper sqLiteHelper;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade(DATABASE_VERSION);
    }

    public static SQLiteHelper builder(Context context) {
        if (sqLiteHelper == null) {
            sqLiteHelper = new SQLiteHelper(context);
        }
        return sqLiteHelper;
    }

    public String getAirportName(String iata) {
        String airportname = "";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT name FROM airport WHERE iata = '" + iata + "'", null);
        if (cursor == null) {
            return airportname;
        }
        cursor.moveToFirst();
        airportname = cursor.getString(cursor.getColumnIndex("name"));
        cursor.close();
        database.close();
        return airportname;
    }
}
