package com.garytokman.tokmangary_ce02;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce02.Fragments.AthleteListFragment;
import com.garytokman.tokmangary_ce02.Fragments.BaseballPlayerFragment;
import com.garytokman.tokmangary_ce02.Fragments.BasketballPlayerFragment;
import com.garytokman.tokmangary_ce02.Fragments.FootballPlayerFragment;
import com.garytokman.tokmangary_ce02.Model.Athlete;
import com.garytokman.tokmangary_ce02.Model.SaveAthlete;

import java.util.List;

// Gary Guerman Tokman
// JAVA 2 1609
// MAINActivity

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity";
    private static final String ATHLETE_LIST = "Athlete_List_Fragment";
    private static final String BASEBALL_PLAYER = "Baseball Player";
    private static final String BASKETBALL_PLAYER = "Basketball Player";
    private static final String FOOTBALL_PLAYER = "Football Player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            // Init UI
            Spinner spinner = (Spinner) findViewById(R.id.object_spinner);
            spinner.setOnItemSelectedListener(this);
            ImageButton refreshButton = (ImageButton) findViewById(R.id.button_refresh);
            refreshButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_refresh:
                Log.d(TAG, "onClick: Refresh!");
                // Get saved Athletes
                SaveAthlete saveAthlete = new SaveAthlete(view.getContext());

                // Hold saved
                List<Athlete> athletes = saveAthlete.loadAthletes();

                // Create Athlete list fragment with factory patter
                AthleteListFragment athleteListFragment = AthleteListFragment.newInstance(athletes);

                // Add fragment
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction
                        .replace(R.id.list_container, athleteListFragment, ATHLETE_LIST)
                        .commit();

                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedPlayer = adapterView.getSelectedItem().toString();
        Log.d(TAG, "onItemSelected: " + selectedPlayer);
        // Create fragment
        Fragment fragment = getFragmentManager().findFragmentByTag(selectedPlayer);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Check if Fragment exists
        if (fragment == null) {
            switch (selectedPlayer) {
                case BASKETBALL_PLAYER:
                    fragment = new BasketballPlayerFragment();
                    break;
                case BASEBALL_PLAYER:
                    fragment = new BaseballPlayerFragment();
                    break;
                case FOOTBALL_PLAYER:
                    fragment = new FootballPlayerFragment();
                    break;
                default:
                    break;
            }
        }

        // Replace container with selected Fragment
        transaction.replace(R.id.form_container, fragment, selectedPlayer)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
