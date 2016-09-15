package com.garytokman.tokmangary_ce07.Fragments;

import android.app.ListFragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.garytokman.tokmangary_ce07.Activities.DetailActivity;
import com.garytokman.tokmangary_ce07.Database.AthleteDatabase;
import com.garytokman.tokmangary_ce07.Database.DatabaseSchema.AthleteTable.Columns;
import com.garytokman.tokmangary_ce07.Helpers.CursorHelper;
import com.garytokman.tokmangary_ce07.Model.Athlete;

// Gary Tokman
// JAV2 - 1609
// AthleteListFragment

public class AthleteListFragment extends ListFragment {

    public static final String SELECTION = "Selected_Athlete";
    SimpleCursorAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AthleteDatabase athleteDatabase = AthleteDatabase.getInstance(getActivity());
        Cursor athletes = athleteDatabase.getAllAthletes();

        String[] from = {Columns.NAME, Columns.POSITION};
        int[] to = {android.R.id.text1, android.R.id.text2};

        adapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_2, athletes, from, to, 1);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor athleteCursor = (Cursor) l.getAdapter().getItem(position);
        CursorHelper cursorHelper = new CursorHelper(athleteCursor);
        Athlete athlete = cursorHelper.getAthlete();

        // Start detail intent
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(SELECTION, athlete);
        startActivity(intent);
    }
}
