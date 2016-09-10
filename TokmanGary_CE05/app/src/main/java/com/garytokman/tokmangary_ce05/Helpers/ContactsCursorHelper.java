package com.garytokman.tokmangary_ce05.Helpers;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;

import java.io.Serializable;

// Gary Tokman
// JAVA 2 1609
// ContactsCursorHelper

public class ContactsCursorHelper extends CursorWrapper implements Serializable {

    public ContactsCursorHelper(Cursor cursor) {
        super(cursor);
    }

    public String getName() {
        return getString(getColumnIndex(Contacts.DISPLAY_NAME));
    }

    public String getNumber() {
        return getString(getColumnIndex(Phone.NUMBER));
    }

    public String getEmail() {
        return getString(getColumnIndex(Email.ADDRESS));
    }

    public String getImage() {
        return getString(getColumnIndex(Phone.PHOTO_URI));
    }
}
