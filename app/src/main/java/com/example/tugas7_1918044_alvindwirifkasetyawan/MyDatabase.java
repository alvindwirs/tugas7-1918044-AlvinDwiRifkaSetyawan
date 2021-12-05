package com.example.tugas7_1918044_alvindwirifkasetyawan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_bajubola";
    private static final String tb_jersey = "tb_jersey";
    private static final String tb_jersey_id = "id";
    private static final String tb_jersey_nama = "nama";
    private static final String tb_jersey_ukuran = "ukuran";
    private static final String CREATE_TABLE_JERSEY = "CREATE TABLE " +
            tb_jersey +"("
            + tb_jersey_id + " INTEGER PRIMARY KEY ,"
            + tb_jersey_nama + " TEXT ,"
            + tb_jersey_ukuran + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_JERSEY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateJersey(Jersey data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jersey_id, data.get_id());
        values.put(tb_jersey_nama, data.get_nama());
        values.put(tb_jersey_ukuran, data.get_ukuran());
        db.insert(tb_jersey, null, values);
        db.close();
    }
    public List<Jersey> ReadJersey() {
        List<Jersey> Listjrs = new ArrayList<Jersey>();
        String selectQuery = "SELECT * FROM " + tb_jersey;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Jersey data = new Jersey();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_ukuran(cursor.getString(2));
                Listjrs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return Listjrs;
    }
    public int UpdateJersey(Jersey data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jersey_nama, data.get_nama());
        values.put(tb_jersey_ukuran, data.get_ukuran());
        return db.update(tb_jersey, values, tb_jersey_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteJersey(Jersey data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_jersey, tb_jersey_id + " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

