package com.garytokman.tokmangary_ce02;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce02.Fragments.BaseballPlayerFragment;
import com.garytokman.tokmangary_ce02.Fragments.BasketballPlayerFragment;
import com.garytokman.tokmangary_ce02.Fragments.FootballPlayerFragment;

// Gary Guerman Tokman
// JAVA 2 1609
// MAINActivity

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity";
    private static final String BASEBALL_PLAYER = "Baseball Player";
    private static final String BASKETBALL_PLAYER = "Basketball Player";
    private static final String FOOTBALL_PLAYER = "Football Player";
    private static final String FORM_FRAGMENT = "Form_Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == configuration.ORIENTATION_LANDSCAPE) {

            // Init UI
            Spinner spinner = (Spinner) findViewById(R.id.object_spinner);
            spinner.setOnItemSelectedListener(this);
            ImageButton refreshButton = (ImageButton) findViewById(R.id.button_refresh);
            refreshButton.setOnClickListener(this);
            Button saveButton = (Button) findViewById(R.id.save_button);
            saveButton.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_refresh:
                Log.d(TAG, "onClick: Refresh!");
                // TODO: Update List Fragment with User Added Vehicle
                break;
            case R.id.save_button:
                Log.d(TAG, "onClick: Save!");
                // TODO: Save Form Input in ArrayList
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedPlayer = adapterView.getSelectedItem().toString();
        Log.d(TAG, "onItemSelected: " + selectedPlayer);
        Fragment fragment = getFragmentManager().findFragmentByTag(selectedPlayer);

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

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.form_container, fragment, selectedPlayer)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
