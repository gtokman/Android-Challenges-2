package com.garytokman.tokmangary_ce01;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce01.model.Repositories;
import com.garytokman.tokmangary_ce01.model.Repository;
import com.garytokman.tokmangary_ce01.network.APIClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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
                if (isNetworkOn()) {
//                    alert(view.getContext(), "Network Info", "Your connected to the network").show();
                    handleSelectedEndpoint(adapterView.getSelectedItem().toString());
                } else {
                    // TODO: LoadData from File
                    alert(view.getContext(), "Network Info", "Your are not connected sorry!").show();
                    Repositories repositories = new Repositories(view.getContext());
                    Log.d(TAG, "onItemSelected: Loading........... saved data............");
                    try {
                        loadRepositoriesLocal(repositories);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
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
    public void parseJson(String json) throws JSONException, IOException, ClassNotFoundException {
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
        saveRepositoriesLocal();
    }

    private void saveRepositoriesLocal() throws IOException, ClassNotFoundException {
        // Save data
        Repositories repositories = new Repositories(this, mRepositories);
        repositories.saveDataToFile();

        loadRepositoriesLocal(repositories);
    }

    private void loadRepositoriesLocal(Repositories repositories) throws IOException, ClassNotFoundException {
        // Load
        if (repositories.doesFileExist()) {

            ArrayAdapter<Repository> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repositories.readDataFromFile());
            mListView.setAdapter(arrayAdapter);
        } else {
            alert(this, "No Saved Files", "Sorry there are no saved files to load!").show();
        }
    }

    public AlertDialog.Builder alert(Context context, String title, String message) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null);

        return alertBuilder;
    }

    public boolean isNetworkOn() {
        // Get network info
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
