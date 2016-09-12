package com.garytokman.tokmangary_ce06;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.garytokman.tokmangary_ce06.Fragments.BookListFragment;
import com.garytokman.tokmangary_ce06.Helpers.ReadBookProvider;

// Gary Tokman
// JAV2 - 1609
// MainActivity

public class MainActivity extends AppCompatActivity {

    private static final String LIST_FRAG = "List_Fragment";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add list fragment
        FragmentManager fragmentManager = getFragmentManager();
        Fragment listFragment = fragmentManager.findFragmentByTag(LIST_FRAG);

        if (listFragment == null) {
            listFragment = new BookListFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.list_container, listFragment, LIST_FRAG)
                    .commit();
        }

        ReadBookProvider readBookProvider = new ReadBookProvider(getContentResolver());
        Cursor cursor = readBookProvider.getBookData();
        Uri bookUri = Uri.parse("content://com.fullsail.ce6.provider/books");
        String title = Uri.withAppendedPath(bookUri, "title").toString();
        Log.d(TAG, "onCreate: book URI and title uri = " + bookUri + " " + title);

        if (cursor == null) {
            Log.d(TAG, "onCreate: null cursor");
        } else {
            Log.d(TAG, "onCreate: cursor has something in it!");
            if (cursor.moveToFirst()) {
                String name = cursor.getString(cursor.getColumnIndex("title"));
                String thumbnail = cursor.getString(cursor.getColumnIndex("thumbnail"));
                String description = cursor.getString(cursor.getColumnIndex("description"));

                Log.d(TAG, "onCreate: name: " + name + " thumbnail " + thumbnail + " description " + description );
            }
        }
    }
}
