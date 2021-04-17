//DATABASE FOR DRINKS PAGE

package com.example.foodies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

//import androidx.annotation.Nullable;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.text.BreakIterator;

public class DrinksData extends SQLiteOpenHelper {
    public static final String DB_NAME = "Drinks.db";
    public static final int DB_VERSION = 1;
    public static final String QUERY_CREATE_DRINKS_TABLE =
            "create table Drinks(name text, description text, price text)";

    public DrinksData(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY_CREATE_DRINKS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Drinks");
        onCreate(sqLiteDatabase);
    }
     long insertData(String name, String description, String price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name", name);
        content.put("description", description);
        content.put("price", price);
        long drink_id = db.insert("Drinks", null, content);
        db.close();
        return drink_id;
    }

    Cursor getAllData() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Drinks order by rowid desc", null);
        return cursor;
    }
}
