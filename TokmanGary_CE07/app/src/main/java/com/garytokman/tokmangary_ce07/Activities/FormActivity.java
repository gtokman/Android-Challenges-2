package com.garytokman.tokmangary_ce07.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.garytokman.tokmangary_ce07.Fragments.FormFragment;
import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// FormActivity

public class FormActivity extends AppCompatActivity {

    private static final String TAG = "FromActivity";
    private static final String FORM_FRAGMENT = "Form_Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Init tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.form_menu);
        setSupportActionBar(toolbar);

        // Init fragment
        FragmentManager fragmentManager = getFragmentManager();
        FormFragment formFragment = new FormFragment();
        fragmentManager
                .beginTransaction()
                .replace(R.id.form_container, formFragment, FORM_FRAGMENT)
                .commit();
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
