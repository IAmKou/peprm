package com.example.peprm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PE.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Employee (" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FullName TEXT, " +
                "HireDate TEXT, " +
                "Salary TEXT)";
        db.execSQL(sql);

        sql = "Insert Into Employee Values (null, 'Nguyen Van A', '07-07-2024', '2000$')";
        db.execSQL(sql);
        sql = "Insert Into Employee Values (null, 'Nguyen Van B', '08-07-2024', '3000$')";
        db.execSQL(sql);
        sql = "Insert Into Employee Values (null, 'Nguyen Van C', '09-07-2024', '4000$')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("Drop Table if exists Employee");
    onCreate(db);
    }
}
