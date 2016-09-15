package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBar;
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

        // Change action bar title
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Detail");
        }

        // Get athlete from intent
        mAthlete = (Athlete) getIntent().getSerializableExtra(AthleteListFragment.SELECTION);

        return DetailFragment.newInstance(mAthlete);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete_toolbar_button:
                Log.d(TAG, "delete button pressed");
                // Delete
                deleteAthlete();

                break;
            case R.id.share_toolbar_button:
                Log.d(TAG, "share button pressed: ");
                // Share intent
                shareAthlete();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareAthlete() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, mAthlete.toString());
        intent.setType("text/plain");
        startActivity(intent);
    }

    private void deleteAthlete() {
        AthleteDatabase athleteDatabase = AthleteDatabase.getInstance(this);
        athleteDatabase.deleteAthlete(Columns.JERSEY_NUMBER + " = ?",
                new String[]{String.valueOf(mAthlete.getJerseyNumber())});
        Toast.makeText(this, "Athlete deleted", Toast.LENGTH_SHORT).show();
        finish();
    }
}
