package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.view.Menu;

import com.garytokman.tokmangary_ce08.Fragments.FormFragment;
import com.garytokman.tokmangary_ce08.Model.Person;
import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// FormActivity

public class FormActivity extends BaseActivity implements FormFragment.OnPersonListener {

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
    public void getPerson(Person person) {
        if (person != null) {
            mPerson = person;
        }
    }
}
