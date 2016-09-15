package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.garytokman.tokmangary_ce07.Database.AthleteDatabase;
import com.garytokman.tokmangary_ce07.Database.DatabaseSchema.AthleteTable.Columns;
import com.garytokman.tokmangary_ce07.Fragments.AthleteListFragment;
import com.garytokman.tokmangary_ce07.Fragments.DetailFragment;
import com.garytokman.tokmangary_ce07.Model.Athlete;
import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// DetailActivity

public class DetailActivity extends BaseActivity {

    private static final String TAG = "Detail Activity";
    private Athlete mAthlete;

    @Override
    public Fragment getFragment() {

        getSupportActionBar().setTitle("Detail");

        mAthlete = (Athlete) getIntent().getSerializableExtra(AthleteListFragment.SELECTION);

        return new DetailFragment().newInstance(mAthlete);
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
                // Delete
                deleteAthlete();

                break;
            case R.id.share_toolbar_button:
                Log.d(TAG, "share button pressed: ");
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteAthlete() {
        AthleteDatabase athleteDatabase = AthleteDatabase.getInstance(this);
        athleteDatabase.deleteAthlete(Columns.JERSEY_NUMBER + " = ?",
                new String[] {String.valueOf(mAthlete.getJerseyNumber())});
        Toast.makeText(this, "Athlete deleted", Toast.LENGTH_SHORT).show();
        finish();
    }
}
