package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;

import com.garytokman.tokmangary_ce08.Fragments.DetailFragment;
import com.garytokman.tokmangary_ce08.Model.Person;
import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// DetailActivity

public class DetailActivity extends BaseActivity {

    @Override
    protected Fragment getFragment() {
        // Get intent
        Intent intent = getIntent();
        // Init
        mPerson = new Person(intent.getStringExtra(EXTRA_STRING_FIRST_NAME),
                intent.getStringExtra(EXTRA_STRING_LAST_NAME),
                intent.getIntExtra(EXTRA_INTEGER_AGE, 1));


        return DetailFragment.newInstance(mPerson);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        return true;
    }
}
