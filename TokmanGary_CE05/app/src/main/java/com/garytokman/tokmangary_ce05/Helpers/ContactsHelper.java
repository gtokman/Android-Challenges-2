package com.garytokman.tokmangary_ce05.Helpers;

// Gary Tokman
// JAVA 2 1609
// ContactsHelper

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.provider.ContactsContract.Contacts;

import static android.provider.ContactsContract.CommonDataKinds.Phone;

public class ContactsHelper {

    private final ContentResolver mContentResolver;

    public ContactsHelper(ContentResolver contentResolver) {
        mContentResolver = contentResolver;
    }

    public Cursor getContactData() {

        // Params
        String whereClause = "" + Contacts.HAS_PHONE_NUMBER + " > 0 and " + Phone.TYPE + " = " + Phone.TYPE_MOBILE
                + " and " + Phone.NUMBER + " is not null" + " and " + Phone.DISPLAY_NAME + " is not null";
        String sortOrder = Contacts.DISPLAY_NAME + " ASC";

        return mContentResolver.query(
                Phone.CONTENT_URI,
                new String[]{
                        Phone.PHOTO_URI,
                        Phone.NUMBER,
                        Photo.CONTACT_ID,
                        Contacts.DISPLAY_NAME,
                        Contacts._ID,
                        Contacts.DISPLAY_NAME_PRIMARY,
                        Email.DATA,
                        Email._ID,
                        Email.ADDRESS,
                        Email.CONTACT_ID,
                },
                whereClause,
                null,
                sortOrder
        );
    }

    public String getEmailData(String where) {
        Cursor emailCursor = mContentResolver.query(
                Email.CONTENT_URI,
                new String[]{
                        Email.DATA,
                        Email.ADDRESS,
                        Email._ID,
                        Email.CONTACT_ID
                },
                Email.CONTACT_ID + " = ?",
                new String[] {where},
                null
        );

        if (emailCursor != null && emailCursor.moveToFirst()) {
            String email = emailCursor.getString(emailCursor.getColumnIndex(Email.ADDRESS));
            emailCursor.close();

            return email;
        }

        return null;
    }

}



