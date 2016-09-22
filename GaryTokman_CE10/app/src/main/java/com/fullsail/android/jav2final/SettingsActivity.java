package com.fullsail.android.jav2final;

import android.app.Activity;
import android.os.Bundle;

import com.fullsail.android.jav2final.fragment.SettingsFragment;


public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        if(savedInstanceState == null) {
            SettingsFragment frag = new SettingsFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, frag, SettingsFragment.TAG)
                    .commit();
        }
    }
}
