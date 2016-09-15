package com.garytokman.tokmangary_ce07.Database;

// Gary Tokman
// JAV2 - 1609
// AthleteDatabase

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.garytokman.tokmangary_ce07.Database.DatabaseSchema.AthleteTable;
import com.garytokman.tokmangary_ce07.Database.DatabaseSchema.AthleteTable.Columns;

// Gary Tokman
// JAV2 - 1609
// AthleteDatabase

public class AthleteDatabase extends SQLiteOpenHelper {

    private static final String TAG = "AthleteDatabase";
    private static AthleteDatabase sAthleteDatabase;
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "ArticlesProvider.db";
    private static final String CREATE_TABLE = "create table if not exists " +
            AthleteTable.NAME + "(" +
            Columns.ID + " integer primary key autoincrement, " +
            Columns.NAME + " text, " +
            Columns.POSITION + " text, " +
            Columns.JERSEY_NUMBER + " int " + ")";

    public static AthleteDatabase getInstance(Context context) {

        if (sAthleteDatabase == null) {
            sAthleteDatabase = new AthleteDatabase(context);
        }

        return sAthleteDatabase;
    }

    private AthleteDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d(TAG, "Creating table.......");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Upgrade
    }
}
