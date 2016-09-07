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

import com.garytokman.tokmangary_ce03.Fragments.FirstDetailFragment;
import com.garytokman.tokmangary_ce03.Fragments.RepoListFragment;
import com.garytokman.tokmangary_ce03.Fragments.SecondDetailFragment;
import com.garytokman.tokmangary_ce03.Fragments.ThirdDetailFragment;
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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, APIClient.APIClientJson, RepoListFragment.LoadDetailView {


    private static final String TAG = "MainActivity";
    private static final String REPO_LIST_FRAGMENT = "Repo_List_Fragment";
    private String selectedDetail;
    private Repositories mRepositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        Spinner spinner = (Spinner) findViewById(R.id.detail_spinner);
        spinner.setOnItemSelectedListener(this);
        mRepositories = Repositories.getInstance(this);

        // Make API call
        if (mRepositories.getRepositories().isEmpty()) {
            APIClient apiClient = new APIClient(this);
            apiClient.execute(Uri.encode(getString(R.string.api_parameter)));
        } else {
            createListFragment();
        }
        // Init fragment
        Log.d(TAG, "onCreate: " + selectedDetail);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemSelected: " + adapterView.getSelectedItem().toString());

        // TODO: Update the detail with different fragments
        selectedDetail = adapterView.getSelectedItem().toString();

    }

    @Override
    public void parseJson(String json) throws JSONException {

        // Parse Json
        JSONObject jsonObject = new JSONObject(json);
        JSONArray itemsArray = jsonObject.getJSONArray("items");
        List<Repository> repositories = new ArrayList<>();

        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject itemsDict = itemsArray.getJSONObject(i);
            JSONObject owner = itemsDict.getJSONObject("owner");
            String name = itemsDict.getString("name");
            String imageUrl = owner.getString("avatar_url");
            String language = itemsDict.getString("language");
            int stars = itemsDict.getInt("stargazers_count");

            Log.d(TAG, "name: " + name + " imageUrl: " + imageUrl + " lang: " + language + " stars: " + stars);

            repositories.add(new Repository(name, imageUrl, stars, language));
        }

        mRepositories.setRepositories(repositories);
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

    @Override
    public void getDetailData(Repository repository) {

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(selectedDetail);

        switch (selectedDetail) {
            case "Detail 1":
                fragment = new FirstDetailFragment().newInstance(repository);
                break;
            case "Detail 2":
                fragment = new SecondDetailFragment().newInstance(repository);
                break;
            case "Detail 3":
                fragment = new ThirdDetailFragment().newInstance(repository);
                break;
            default:
                break;

        }

        fragmentManager
                .beginTransaction()
                .replace(R.id.detail_container, fragment, selectedDetail)
                .addToBackStack(null).commit();
    }
}
