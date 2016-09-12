package com.garytokman.tokmangary_ce06.Helpers;

import android.database.Cursor;
import android.database.CursorWrapper;

// Gary Tokman
// JAV2 - 1609
// CursorHelper

public class CursorHelper extends CursorWrapper {
    public CursorHelper(Cursor cursor) {
        super(cursor);
    }

    public String getBookTitle() {
        return getString(getColumnIndex(""));
    }

    public String getBookThumbnail() {
        return getString(getColumnIndex(""));
    }
}
