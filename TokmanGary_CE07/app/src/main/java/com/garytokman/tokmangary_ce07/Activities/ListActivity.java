package com.garytokman.tokmangary_ce07.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.garytokman.tokmangary_ce07.Fragments.AthleteListFragment;
import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// ListActivity

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "List_Activity";
    private static final String LIST_FRAGMENT = "List_Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.list_menu);
        setSupportActionBar(toolbar);

        // Add list fragment
        FragmentManager fragmentManager = getFragmentManager();
        AthleteListFragment athleteListFragment = new AthleteListFragment();
        fragmentManager
                .beginTransaction()
                .replace(R.id.list_container, athleteListFragment, LIST_FRAGMENT)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu
        getMenuInflater().inflate(R.menu.list_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // Start activity
        if (id == R.id.form_toolbar_button) {
            Log.d(TAG, "Form button click: ");

            // Show form
            Intent intent = new Intent(this, FormActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
