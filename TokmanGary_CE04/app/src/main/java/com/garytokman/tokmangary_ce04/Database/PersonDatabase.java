package com.garytokman.tokmangary_ce04.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.garytokman.tokmangary_ce04.Database.PersonDatabaseSchema.PersonTable;

// Gary Tokman
// JAV2 - 1609
// PersonDatabase

public class PersonDatabase extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "person.db";
    private static final String CREATE_TABLE = "create table if not exists " +
            PersonTable.NAME + "(" +
            PersonTable.Columns.ID + " integer primary key autoincrement, " +
            PersonTable.Columns.FIRSTNAME + " text, " +
            PersonTable.Columns.LASTNAME + " text, " +
            PersonTable.Columns.EMPLOYEE_ID + " integer, " +
            PersonTable.Columns.HIREDATE + " date, " +
            PersonTable.Columns.STATUS + " text" + ")";
    private static final String TAG = "PersonDB";

    public PersonDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create database
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d(TAG, "onCreate: Creating new db................");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Upgrade database

    }
}
