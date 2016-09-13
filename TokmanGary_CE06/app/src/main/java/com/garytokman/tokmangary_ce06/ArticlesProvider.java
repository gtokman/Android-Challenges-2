package com.garytokman.tokmangary_ce06;

// Gary Tokman
// JAV2 - 1609
// ArticlesProvider

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.garytokman.tokmangary_ce06.Database.ArticleDatabase;
import com.garytokman.tokmangary_ce06.Database.DatabaseSchema.ArticleTable;

public class ArticlesProvider extends ContentProvider {

    public static final String AUTHORITY = "com.fullsail.ce6.student.provider";
    UriMatcher mUriMatcher;

    @Override
    public boolean onCreate() {
        // Init content provider on start
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(AUTHORITY, ArticleTable.NAME, 1);
        mUriMatcher.addURI(AUTHORITY, ArticleTable.NAME + "/#", 2);

        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String whereClause, String[] whereArgs, String sort) {
        // handle query requests from book app

        final int matcher = mUriMatcher.match(uri);
        Cursor query;

        switch (matcher) {
            case 1:
                query = ArticleDatabase.newInstance(getContext()).getReadableDatabase().query(
                        ArticleTable.NAME,
                        projection,
                        whereClause,
                        whereArgs,
                        null,
                        null,
                        sort
                );

                return query;
            case 2:
                query = ArticleDatabase.newInstance(getContext()).getReadableDatabase().query(
                        ArticleTable.NAME,
                        projection,
                        "_id = ?",
                        new String[]{String.valueOf(ContentUris.parseId(uri))},
                        null,
                        null,
                        sort
                );

                return query;

            default:
                query = ArticleDatabase.newInstance(getContext()).getReadableDatabase().query(
                        ArticleTable.NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                );


                return query;
        }


    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        // handle requests for MIME type // URI
        final int matcher = mUriMatcher.match(uri);

        switch (matcher) {
            case 1:
                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + AUTHORITY + "/" + ArticleTable.NAME;
            case 2:
                return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + AUTHORITY + "/" + ArticleTable.NAME;
            default:
                throw new UnsupportedOperationException("Uri is not found");
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
