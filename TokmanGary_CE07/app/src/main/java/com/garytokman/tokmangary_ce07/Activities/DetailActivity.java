package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.garytokman.tokmangary_ce07.Fragments.AthleteListFragment;
import com.garytokman.tokmangary_ce07.Fragments.DetailFragment;
import com.garytokman.tokmangary_ce07.Model.Athlete;
import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// DetailActivity

public class DetailActivity extends BaseActivity {

    private static final String TAG = "Detail Activity";

    @Override
    public Fragment getFragment() {

        Athlete athlete = (Athlete) getIntent().getSerializableExtra(AthleteListFragment.SELECTION);

        return new DetailFragment().newInstance(athlete);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.delete_toolbar_button:
                Log.d(TAG, "delete button pressed");
                break;
            case R.id.share_toolbar_button:
                Log.d(TAG, "share button pressed: ");
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
