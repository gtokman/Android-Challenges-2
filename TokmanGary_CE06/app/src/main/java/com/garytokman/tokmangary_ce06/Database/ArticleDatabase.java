package com.garytokman.tokmangary_ce06.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.garytokman.tokmangary_ce06.Database.DatabaseSchema.ArticleTable;
import com.garytokman.tokmangary_ce06.Database.DatabaseSchema.ArticleTable.Columns;
import com.garytokman.tokmangary_ce06.Model.Articles;

// Gary Tokman
// JAV2 - 1609
// ArticleDatabase

public class ArticleDatabase extends SQLiteOpenHelper {

    private static final String TAG = "ArticleDB";
    private static ArticleDatabase sArticleDatabase;
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "articles.db";
    private static final String CREATE_TABLE = "create table if not exists " +
            ArticleTable.NAME + "(" +
            Columns.ID + " integer primary key autoincrement, " +
            Columns.TITLE + " text, " +
            Columns.THUMBNAIL + " text, " +
            Columns.BODY + " text, " + ")";

    private ArticleDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static ArticleDatabase newInstance(Context context) {
        if (sArticleDatabase == null) {
            sArticleDatabase = new ArticleDatabase(context);
        }

        return sArticleDatabase;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d(TAG, "onCreate: creating table...........");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addArticles() {
        ContentValues contentValues = getValues();

        // Insert
        getWritableDatabase().insert(ArticleTable.NAME, null, contentValues);
    }

    public ContentValues getValues() {

        ContentValues contentValues = new ContentValues();
        String[] columns = {Columns.TITLE, Columns.THUMBNAIL, Columns.BODY};

        for (int i = 0; i < Articles.sArticles().size(); i++) {
           contentValues.put(columns[i], Articles.sArticles().get(i).getTitle());
        }

        return contentValues;
    }
}
