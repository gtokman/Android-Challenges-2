package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// BaseActivity

public abstract class BaseActivity extends AppCompatActivity {

    private static final String FRAGMENT = "Main_Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        // Init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);

        // Add list fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.list_container, getFragment(), FRAGMENT)
                .commit();
    }

    protected abstract Fragment getFragment();
}
