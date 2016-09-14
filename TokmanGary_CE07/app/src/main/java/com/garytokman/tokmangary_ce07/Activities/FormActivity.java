package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.garytokman.tokmangary_ce07.Fragments.FormFragment;
import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// FormActivity

public class FormActivity extends BaseActivity {

    private static final String TAG = "FromActivity";

    @Override
    public Fragment getFragment() {
        return new FormFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.save_toolbar_button) {
            Log.d(TAG, "form save button: ");
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
