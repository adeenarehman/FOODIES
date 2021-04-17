//DATABASE FOR DESSERT PAGE

package com.example.foodies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

import androidx.annotation.Nullable;
public class DessertData extends SQLiteOpenHelper {
    public static final String DB_NAME = "Dessert.db";
    public static final int DB_VERSION = 1;
    public static final String QUERY_CREATE_DESSERT_TABLE =
            "create table Dessert(name text, description text, price text)";

    public DessertData(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY_CREATE_DESSERT_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Dessert");
        onCreate(sqLiteDatabase);
    }
    long insertData(String name, String description, String price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name", name);
        content.put("description", description);
        content.put("price", price);
        long desserts_id = db.insert("Dessert", null, content);
        db.close();
        return desserts_id;
    }
    Cursor getAllData() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Dessert order by rowid desc", null);
        return cursor;
    }
}