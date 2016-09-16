package com.garytokman.tokmangary_ce08;

import android.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.garytokman.tokmangary_ce08.Activities.BaseActivity;
import com.garytokman.tokmangary_ce08.Fragments.FormFragment;

// Gary Tokman
// JAV2 - 1609
// FormActivity

public class FormActivity extends BaseActivity {

    private static final String TAG = "FormActivity";

    @Override
    protected Fragment getFragment() {
        return new FormFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.form_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.save_button) {
            Toast.makeText(this, "Saved person", Toast.LENGTH_SHORT).show();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
