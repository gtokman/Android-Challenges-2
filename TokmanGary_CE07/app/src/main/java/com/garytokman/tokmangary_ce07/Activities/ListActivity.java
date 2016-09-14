package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.garytokman.tokmangary_ce07.Fragments.AthleteListFragment;
import com.garytokman.tokmangary_ce07.R;

public class ListActivity extends BaseActivity {

    private static final String TAG = "List_Activity";

    @Override
    public Fragment getFragment() {
        return new AthleteListFragment();
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
