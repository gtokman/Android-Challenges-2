package com.garytokman.tokmangary_ce05.Helpers;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.provider.ContactsContract.Contacts;

import java.util.ArrayList;
import java.util.List;

// Gary Tokman
// JAVA 2 1609
// ContactsCursorHelper

public class ContactsCursorHelper extends CursorWrapper {

    private static final String TAG = "ContactsCursorHelper";
    private Cursor mCursor;

    public ContactsCursorHelper(Cursor cursor) {
        super(cursor);
        mCursor = cursor;
    }

    public List<String> getContactName() {

        List<String> contacts = new ArrayList<>();

//        Log.d(TAG, "getContactName: " + getString(getColumnIndex(Contacts.DISPLAY_NAME)));
        while (mCursor.moveToNext()) {
            String name = getString(getColumnIndex(Contacts.DISPLAY_NAME));
            contacts.add(name);
        }

        return contacts;
    }
}
