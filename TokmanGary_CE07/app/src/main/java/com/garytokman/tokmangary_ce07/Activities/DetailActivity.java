package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;

import com.garytokman.tokmangary_ce07.Fragments.AthleteListFragment;
import com.garytokman.tokmangary_ce07.Fragments.DetailFragment;
import com.garytokman.tokmangary_ce07.Model.Athlete;

// Gary Tokman
// JAV2 - 1609
// DetailActivity

public class DetailActivity extends BaseActivity {

    @Override
    public Fragment getFragment() {

        Athlete athlete = (Athlete) getIntent().getSerializableExtra(AthleteListFragment.SELECTION);

        return new DetailFragment().newInstance(athlete);
    }
}
