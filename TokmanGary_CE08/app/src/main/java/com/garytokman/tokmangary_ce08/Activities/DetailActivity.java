package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import com.garytokman.tokmangary_ce08.Fragments.DetailFragment;

// Gary Tokman
// JAV2 - 1609
// DetailActivity

public class DetailActivity extends BaseActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected Fragment getFragment() {

        Bundle bundle = getIntent().getExtras();
        bundle.keySet();
        for (String names : bundle.keySet()) {
            Log.d(TAG, "getFragment: " + names);
        }


        return new DetailFragment();
    }



}
