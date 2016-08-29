package com.garytokman.tokmangary_ce01;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce01.network.APIClient;

// Gary Guerman Tokman
// JAV2 - 1609
// MainActivity

public class MainActivity extends AppCompatActivity implements APIClient.UpdateUIWithJson {

    private static final String TAG = "MainActivity";
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
                handleSelectedEndpoint(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void handleSelectedEndpoint(String selection) {
        Log.d(TAG, "handleSelectedEndpoint() called with: " + "selection = " + selection);

        APIClient apiClient = new APIClient(this);
        apiClient.execute(Uri.encode(selection));
    }

    @Override
    public void parseJson(String json) {
        Log.d(TAG, "parseJson() called with: " + "json = " + json);
    }
}
