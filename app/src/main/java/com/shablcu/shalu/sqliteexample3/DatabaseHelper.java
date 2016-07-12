package com.shablcu.shalu.sqliteexample3;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shalu on 12/7/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Shabalcudatabase";
    private static final String TABLE_NAME = "Shablcutable";
    private static final int DATABASE_VERSION = 5;
    private static final String UID = "id";
    private static final String NAME = "name";
    private static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + UID + "INTEGER PRIMSRY KEY AUTOINCREMENTED," + NAME + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME ;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Message.message(context,"Constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Message.message(context,"onCreate Called");
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Message.message(context,"OnUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
           Message.message(context,""+e);
        }


    }
}
