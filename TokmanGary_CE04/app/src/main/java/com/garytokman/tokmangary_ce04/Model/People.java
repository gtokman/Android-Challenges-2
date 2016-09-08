package com.garytokman.tokmangary_ce04.Model;

// Gary Tokman
// JAV2 - 1609
// MainActivity

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.garytokman.tokmangary_ce04.Database.PersonDatabase;

import java.util.ArrayList;
import java.util.List;

public class People {
    private static People sPeople;
    private List<Person> mPersonList;
    private Context mContext;
    private SQLiteDatabase mPersonDatabase;

    public static People getInstance(Context context) {
        if (sPeople == null) {
            sPeople = new People(context);
        }

        return sPeople;
    }

    private People(Context context) {
        mPersonList = new ArrayList<>();
        mContext = context.getApplicationContext();
        mPersonDatabase = new PersonDatabase(context).getWritableDatabase();
    }
}
