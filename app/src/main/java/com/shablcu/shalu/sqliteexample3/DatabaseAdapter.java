package com.shablcu.shalu.sqliteexample3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter {
    DatabaseHelper helper;

    public DatabaseAdapter(Context context) {
        helper = new DatabaseHelper(context);

    }

    public long insertData(String name, String password) {

        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, name);
        contentValues.put(DatabaseHelper.PASSWORD, password);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        return id;

    }


    public String getAllData() {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] column = {DatabaseHelper.UID, DatabaseHelper.NAME, DatabaseHelper.PASSWORD};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, column, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String Password = cursor.getString(2);
            buffer.append(id + " " + name + " " + Password + "\n");
        }
        return buffer.toString();
    }


    public String getData(String name, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] column = {DatabaseHelper.UID};
        String[] selectionArgs={name,password};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, column,
                DatabaseHelper.NAME + " =?  AND " + DatabaseHelper.PASSWORD + " =? ", selectionArgs, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index0 = cursor.getColumnIndex(DatabaseHelper.UID);

            int personid = cursor.getInt(index0);

            buffer.append(personid  + "\n");
        }
        return buffer.toString();


    }


    static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "Shabalcudatabase";
        private static final String TABLE_NAME = "SHABLCUTABLE";
        private static final int DATABASE_VERSION = 6;
        private static final String UID = "id";
        private static final String NAME = "name";
        private static final String PASSWORD = "password";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                NAME + " VARCHAR(255) , " + PASSWORD + " VARCHAR(255) ); ";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Message.message(context, "Constructor called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                Message.message(context, "onCreate Called");
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                Message.message(context, "OnUpgrade called");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Message.message(context, "" + e);
            }


        }
    }

}
