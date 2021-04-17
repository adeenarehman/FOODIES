package com.example.foodies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Users.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(name text, email text primary key, password text, contact text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");

    }

    //Inserting Data in table
    public boolean insert(String name, String email, String password, String contact) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalue = new ContentValues();

        contentvalue.put("name",name);
        contentvalue.put("email",email);
        contentvalue.put("password",password);
        contentvalue.put("contact",contact);

        long ins = db.insert("user", null,contentvalue);
        if (ins == 1) return false;
        else return true;

    }

    //Checking If Email Exists
    public Boolean checkEmail(String email) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[] {email});

        if (cursor.getCount() > 0) return false;
        else return true;

    }

    //Checking The Emails & Passwords
    public Boolean emailPassword(String email, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=? and password=?", new String[] {email, password});

        if (cursor.getCount() > 0) return true;
        else return false;

    }
}
