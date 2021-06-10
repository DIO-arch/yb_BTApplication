package com.example.josephblan.btapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "EXP.db", null, 1);
    }

    public void insertData(String name, String value){
        SQLiteDatabase db = getWritableDatabase();
        String sql_insert = "INSERT INTO EXP (name, value) values(?,?)";
        SQLiteStatement statement = db.compileStatement(sql_insert);

        statement.bindString(1,name);
        statement.bindString(2,value);
        statement.execute();
    }
    public ArrayList<EXP> getAllEXP() {
        ArrayList<EXP> ary = new ArrayList<>();

        String st = "select * from EXP";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);

        while(cursor.moveToNext()){
            EXP e = new EXP();
            e.setName(cursor.getString(cursor.getColumnIndex("name")));
            e.setValue(cursor.getString(cursor.getColumnIndex("value")));
            e.setId(cursor.getLong(cursor.getColumnIndex("_id")));
            ary.add(e); }
        return ary;
    }
    public Boolean checkUps(String name, String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from exp where name = ? and value = ?", new String[]{name, value});
        if (cursor.getCount() > 0) return true;
        return false;
    }
}

