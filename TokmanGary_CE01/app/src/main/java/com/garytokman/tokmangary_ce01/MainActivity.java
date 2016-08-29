package com.garytokman.tokmangary_ce01;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce01.model.Repository;
import com.garytokman.tokmangary_ce01.network.APIClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// Gary Guerman Tokman
// JAV2 - 1609
// MainActivity

public class MainActivity extends AppCompatActivity implements APIClient.UpdateUIWithJson {

    private static final String TAG = "MainActivity";
    private Spinner mEndPointSpinner;
    private ListView mListView;
    private List<Repository> mRepositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mEndPointSpinner = (Spinner) findViewById(R.id.endpoint_spinner);
        mListView = (ListView) findViewById(R.id.listView);
        mRepositories = new ArrayList<>();

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
        mRepositories.clear();
        APIClient apiClient = new APIClient(this);
        apiClient.execute(Uri.encode(selection));
    }

    @Override
    public void parseJson(String json) throws JSONException {
//        Log.d(TAG, "parseJson() called with: " + "json = " + json);
        JSONObject object = new JSONObject(json);
        JSONArray items = object.getJSONArray("items");

        for (int i = 0; i < items.length(); i++) {
            // Init Repo
            String name = items.getJSONObject(i).getString("full_name");
            String description = items.getJSONObject(i).getString("description");
            int stars = items.getJSONObject(i).getInt("stargazers_count");

            Log.d(TAG, "stars: " + stars + " name: " + name + " desc: " + description);

            mRepositories.add(new Repository(stars, description, name));
        }

        updateUI();
    }

    private void updateUI() {
        ArrayAdapter<Repository> arrayAdapter = new ArrayAdapter<Repository>(this, android.R.layout.simple_list_item_1, mRepositories);
        mListView.setAdapter(arrayAdapter);
    }
}
