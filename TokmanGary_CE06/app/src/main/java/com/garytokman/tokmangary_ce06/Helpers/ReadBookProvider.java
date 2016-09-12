package com.garytokman.tokmangary_ce06.Helpers;

// Gary Tokman
// JAV2 - 1609
// ReadBookProvider

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class ReadBookProvider {

    private ContentResolver mContentResolver;

    public ReadBookProvider(ContentResolver contentResolver) {
        mContentResolver = contentResolver;
    }

    public Cursor getBookData() {

        Uri bookUri = Uri.parse("content://com.fullsail.ce6.provider/books");
        String id = "_id";
        String title = "title";
        String thumbnail = "thumbnail";
        String description = "description";
        String book_id = "book_id";


        String[] projections = {
                id,
                title,
                thumbnail,
                description,
                book_id
        };

        return mContentResolver.query(
                bookUri,
                projections,
                title + " is not null and " + thumbnail +  " is not null and " + description + " is not null",
                null,
                null
        );
    }
}
