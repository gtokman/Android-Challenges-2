package com.garytokman.tokmangary_ce01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

// Gary Guerman Tokman
// JAV2 - 1609
// MainActivity

public class MainActivity extends AppCompatActivity {

    private Spinner mEndPointSpinner;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mEndPointSpinner = (Spinner) findViewById(R.id.endpoint_spinner);
        mListView = (ListView) findViewById(R.id.listView);

        // Listeners
        mEndPointSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                handleSelectedEndpoint(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void handleSelectedEndpoint(int index) {

    }

}
