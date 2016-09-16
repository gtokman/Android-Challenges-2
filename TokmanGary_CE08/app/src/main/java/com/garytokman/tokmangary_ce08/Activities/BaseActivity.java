package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// BaseActivity

public abstract class BaseActivity extends AppCompatActivity {

    private static final String FRAG_TAG = "Fragment_Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        // Set tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);


        // Add fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, getFragment(), FRAG_TAG)
                .commit();
    }

    protected abstract Fragment getFragment();
}
