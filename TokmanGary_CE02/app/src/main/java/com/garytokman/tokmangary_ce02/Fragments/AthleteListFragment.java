package com.garytokman.tokmangary_ce02.Fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.garytokman.tokmangary_ce02.Model.Athlete;

import java.io.Serializable;
import java.util.List;

// Gary Guerman Tokman
// JAVA 2 1609
// AthleteListFragment

public class AthleteListFragment extends ListFragment {

    private static final String ATHLETE_LIST = "Athlete_List";

    // Factory pattern
    public static AthleteListFragment newInstance(List<Athlete> athletes) {

        // Create instance
        AthleteListFragment athleteListFragment = new AthleteListFragment();

        // Create bundle
        Bundle bundle = new Bundle();
        bundle.putSerializable(ATHLETE_LIST, (Serializable) athletes);

        // Add bundle
        athleteListFragment.setArguments(bundle);

        return athleteListFragment;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Get saved bundle
        Bundle bundle = getArguments();
        List<Athlete> athletes = (List<Athlete>) bundle.getSerializable(ATHLETE_LIST);

        if (athletes != null) {
            // Create list
            // Create adapter
            ArrayAdapter<Athlete> athleteArrayAdapter =
                    new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, athletes);
            // Set list adapter
            setListAdapter(athleteArrayAdapter);
        }
    }
}
