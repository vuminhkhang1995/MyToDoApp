package com.khangvu.mytodoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by duyvu on 2/21/16.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_TODOITEMS = "todoitems";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TODOITEM = "item";
    public static final String COLUMN_PRIORITY = "priority";
    public static final String COLUMN_DUE_YEAR = "dueyear";
    public static final String COLUMN_DUE_MONTH = "duemonth";
    public static final String COLUMN_DUE_DATE = "duedate";


    private static final String DATABASE_NAME = "commments.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_TODOITEMS + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TODOITEM + " text not null, "
            + COLUMN_PRIORITY + " text not null, "
            + COLUMN_DUE_YEAR + " integer, "
            + COLUMN_DUE_MONTH + " integer, "
            + COLUMN_DUE_DATE + " integer);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOITEMS);
        onCreate(db);
    }
}
