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
import android.widget.Toast;

import com.garytokman.tokmangary_ce01.model.Repository;
import com.garytokman.tokmangary_ce01.model.SaveRepository;
import com.garytokman.tokmangary_ce01.network.APIClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Gary Guerman Tokman
// JAV2 - 1609
// MainActivity

public class MainActivity extends AppCompatActivity implements APIClient.UpdateUIWithJson {

    private static final String TAG = "MainActivity";
    private ListView mListView;
    private SaveRepository mSaveRepository;
    private Map<String, List<Repository>> mListMap;
    private String mSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        Spinner endPointSpinner = (Spinner) findViewById(R.id.endpoint_spinner);
        mListView = (ListView) findViewById(R.id.listView);

        // Listeners
        endPointSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               mSelection = adapterView.getSelectedItem().toString().trim();

                if (isNetworkOn()) {
                    handleSelectedEndpoint(mSelection);
                } else {
                    try {
                        if (mSaveRepository != null) {
                            loadRepositoriesLocal(mSaveRepository, mSelection);
                        } else {
                            mSaveRepository = new SaveRepository(view.getContext());
                            loadRepositoriesLocal(mSaveRepository, mSelection);
//                            Toast.makeText(MainActivity.this, "No saved data!", Toast.LENGTH_SHORT).show();
                        }
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
//        mRepositories.clear();
        APIClient apiClient = new APIClient(this);
        apiClient.execute(Uri.encode(selection));
    }

    @Override
    public void parseJson(String json) throws JSONException, IOException, ClassNotFoundException {

        List<Repository> mRepositories = new ArrayList<>();

        JSONObject object = new JSONObject(json);
        JSONArray items = object.getJSONArray("items");


        for (int i = 0; i < items.length(); i++) {
            // Init Repo
            String name = items.getJSONObject(i).getString("full_name");
            String description = items.getJSONObject(i).getString("description");
            int stars = items.getJSONObject(i).getInt("stargazers_count");

            Log.d(TAG, "stars: " + stars + " name: " + name + " desc: " + description);

            Repository repository = new Repository(stars, description, name);
            mRepositories.add(repository);

        }

        if (mListMap == null) {
            mListMap = new TreeMap<>();
            mListMap.put(mSelection, mRepositories);
        } else {
            mListMap.put(mSelection, mRepositories);
        }

        updateUI(mListMap.get(mSelection));
        saveRepositoriesLocal();
    }

    private void updateUI(List<Repository> repositoryList) {
        ArrayAdapter<Repository> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repositoryList);
        mListView.setAdapter(arrayAdapter);
    }

    private void saveRepositoriesLocal() throws IOException, ClassNotFoundException {
        // Save data
        if (mSaveRepository == null) {
            mSaveRepository = new SaveRepository(this, mListMap);
        } else {
            mSaveRepository.setRepositories(mListMap);
        }
        mSaveRepository.saveDataToFile();
    }

    private void loadRepositoriesLocal(SaveRepository repositories, String selection) throws IOException, ClassNotFoundException {
        // Load
        Map<String, List<Repository>> map = repositories.readDataFromFile();
        Log.d(TAG, "loadRepositoriesLocal: " + map);
        if (repositories.doesFileExist() && map.get(selection) != null) {
            alert(this, "Network Info", "Your are not connected sorry! Loading any saved data.").show();
            List<Repository> selectedRepo = map.get(selection);
            Log.d(TAG, "loadRepositoriesLocal: " + selectedRepo);
            updateUI(selectedRepo);
        } else {
            List<Repository> temp = new ArrayList<>();
            updateUI(temp);
            Toast.makeText(MainActivity.this, "No Data available", Toast.LENGTH_SHORT).show();
        }
    }

    private AlertDialog.Builder alert(Context context, String title, String message) {
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
