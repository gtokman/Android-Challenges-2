package com.garytokman.tokmangary_ce05.Helpers;

// Gary Tokman
// JAVA 2 1609
// ContactsHelper

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.provider.ContactsContract.Contacts;

import static android.provider.ContactsContract.CommonDataKinds.Phone;

public class ContactsHelper {

    private ContentResolver mContentResolver;
    // + " and "+ Phone.PHOTO_URI + " is not null
    String whereClause = "" + Contacts.HAS_PHONE_NUMBER + " > 0 and " + Phone.TYPE + " = " + Phone.TYPE_MOBILE;
    String sortOrder = Contacts.DISPLAY_NAME + " ASC";

    public ContactsHelper(ContentResolver contentResolver) {
        mContentResolver = contentResolver;
    }

    public Cursor getContactName() {

        Cursor cursor = mContentResolver.query(
                Phone.CONTENT_URI,
                new String[]{
                        Phone.PHOTO_URI,
                        Phone.NUMBER,
                        Photo.CONTACT_ID,
                        Contacts.DISPLAY_NAME,
                        Contacts._ID,
                },
                whereClause,
                null,
                sortOrder
        );

        return cursor;
    }
}
