package com.garytokman.tokmangary_ce03;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce03.Fragments.RepoListFragment;
import com.garytokman.tokmangary_ce03.Model.Repositories;
import com.garytokman.tokmangary_ce03.Model.Repository;
import com.garytokman.tokmangary_ce03.Network.APIClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// Gary Tokman
// JAV2 - 1609
// MainActivity


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, APIClient.APIClientJson {


    private static final String TAG = "MainActivity";
    private static final String REPO_LIST_FRAGMENT = "Repo_List_Fragment";
    private List<Repository> mRepositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        Spinner spinner = (Spinner) findViewById(R.id.detail_spinner);
        spinner.setOnItemSelectedListener(this);
        mRepositories = new ArrayList<>();

        // Make API call
        APIClient apiClient = new APIClient(this);
        apiClient.execute(Uri.encode(getString(R.string.api_parameter)));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemSelected: " + adapterView.getSelectedItem().toString());

        // TODO: Update the detail with different fragments
    }

    @Override
    public void parseJson(String json) throws JSONException {

        // Parse Json
        JSONObject jsonObject = new JSONObject(json);
        JSONArray itemsArray = jsonObject.getJSONArray("items");
        Repositories repositories = Repositories.getInstance(this);

        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject itemsDict = itemsArray.getJSONObject(i);
            JSONObject owner = itemsDict.getJSONObject("owner");
            String name = itemsDict.getString("name");
            String imageUrl = owner.getString("avatar_url");
            String language = itemsDict.getString("language");
            int stars = itemsDict.getInt("stargazers_count");

            Log.d(TAG, "name: " + name + " imageUrl: " + imageUrl + " lang: " + language + " stars: " + stars);

            mRepositories.add(new Repository(name, imageUrl, stars, language));
        }

        repositories.setRepositories(mRepositories);
        createListFragment();
    }

    private void createListFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(REPO_LIST_FRAGMENT);

        if (fragment == null) {
            fragment = new RepoListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.list_container, fragment, REPO_LIST_FRAGMENT)
                    .commit();
        }
    }
}
