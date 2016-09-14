package com.garytokman.tokmangary_ce07.Fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.garytokman.tokmangary_ce07.Model.Athlete;

import java.util.ArrayList;
import java.util.List;

// Gary Tokman
// JAV2 - 1609
// AthleteListFragment

public class AthleteListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        List<Athlete> athletes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            athletes.add(new Athlete("Gary Tokman", "Pitcher", i));
        }

        ArrayAdapter<Athlete> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, athletes);
        setListAdapter(arrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Athlete athlete = (Athlete) l.getAdapter().getItem(position);
        Toast.makeText(getActivity(), athlete.getName(), Toast.LENGTH_SHORT).show();
    }
}
