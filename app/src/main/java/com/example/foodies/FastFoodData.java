
//DATABASE FOR FAST FOOD PAGE

package com.example.foodies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

import androidx.annotation.Nullable;
public class FastFoodData extends SQLiteOpenHelper {
    public static final String DB_NAME = "FastFood.db";
    public static final int DB_VERSION = 1;
    public static final String QUERY_CREATE_FASTFOOD_TABLE =
            "create table FastFood(name text, description text, price text)";

    public FastFoodData(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY_CREATE_FASTFOOD_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists FastFood");
        onCreate(sqLiteDatabase);
    }
    long insertData(String name, String description, String price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name", name);
        content.put("description", description);
        content.put("price", price);
        long fastfood_id = db.insert("FastFood", null, content);
        db.close();
        return fastfood_id;
    }
    Cursor getAllData() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from FastFood order by rowid desc", null);
        return cursor;
    }
}