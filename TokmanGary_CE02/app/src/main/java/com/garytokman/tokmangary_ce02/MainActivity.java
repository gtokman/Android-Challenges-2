package com.garytokman.tokmangary_ce02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init UI
        Spinner spinner = (Spinner) findViewById(R.id.object_spinner);
        ImageButton refreshButton = (ImageButton) findViewById(R.id.button_refresh);
        refreshButton.setOnClickListener(this);
        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);

        // Fragments
        

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_refresh:
                Log.d(TAG, "onClick: Refresh!");
                // TODO: Update List Fragment with User Added Pokemon
                break;
            case R.id.save_button:
                Log.d(TAG, "onClick: Save!");
                // TODO: Save Form Input in ArrayList
                break;
            default:
                break;
        }
    }
}
