package com.garytokman.tokmangary_ce07.Helpers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.garytokman.tokmangary_ce07.Database.DatabaseSchema.AthleteTable.Columns;
import com.garytokman.tokmangary_ce07.Model.Athlete;

import java.io.Serializable;

// Gary Tokman
// JAV2 - 1609
// CursorHelper

public class CursorHelper extends CursorWrapper implements Serializable {
    public CursorHelper(Cursor cursor) {
        super(cursor);
    }


    public String getName() {
        return getString(getColumnIndex(Columns.NAME));
    }

    public String getPositon() {
        return getString(getColumnIndex(Columns.POSITION));
    }

    public int getJerseyNumber() {
        return Integer.valueOf(getString(getColumnIndex(Columns.JERSEY_NUMBER)));
    }

    public Athlete getAthlete() {
        return new Athlete(getString(getColumnIndex(Columns.NAME)),
                getString(getColumnIndex(Columns.POSITION)),
                Integer.valueOf(getString(getColumnIndex(Columns.JERSEY_NUMBER))));
    }

}
