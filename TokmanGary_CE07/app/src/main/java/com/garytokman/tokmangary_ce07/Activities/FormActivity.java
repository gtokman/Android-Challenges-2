package com.garytokman.tokmangary_ce07.Activities;

import android.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.garytokman.tokmangary_ce07.Database.AthleteDatabase;
import com.garytokman.tokmangary_ce07.Fragments.FormFragment;
import com.garytokman.tokmangary_ce07.Model.Athlete;
import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// FormActivity

public class FormActivity extends BaseActivity implements FormFragment.AthleteFormListener {

    private static final String TAG = "FromActivity";
    private Athlete mAthlete;

    @Override
    public Fragment getFragment() {
        getSupportActionBar().setTitle("Add Athletes");
        return new FormFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.save_toolbar_button) {
            if (mAthlete != null) {

                Log.d(TAG, "form save button: " + mAthlete.getName() + mAthlete.getPosition() + mAthlete.getJerseyNumber());
                // Save athlete
                AthleteDatabase athleteDatabase = AthleteDatabase.getInstance(this);
                athleteDatabase.saveAthlete(mAthlete);

                Toast.makeText(this, "Athlete saved", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }

            Toast.makeText(this, "Athlete not saved, no empty fields!", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    @Override
    public void getNewAthlete(Athlete athlete) {

        // Set athlete instance
        if (athlete != null) {
            mAthlete = athlete;
        }
    }
}
