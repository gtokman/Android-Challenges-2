package com.garytokman.tokmangary_ce03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

// Gary Tokman
// JAV2 - 1609
// MainActivity


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        Spinner spinner = (Spinner) findViewById(R.id.detail_spinner);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemSelected: " + adapterView.getSelectedItem().toString());

        // TODO: Update the detail with different fragments
    }
}
