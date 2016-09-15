package com.garytokman.tokmangary_ce07.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garytokman.tokmangary_ce07.Model.Athlete;
import com.garytokman.tokmangary_ce07.R;

// Gary Tokman
// JAV2 - 1609
// DetailFragment

public class DetailFragment extends Fragment {

    private static final String ATHLETE = "Athlete";

    public static DetailFragment newInstance(Athlete athlete) {
        DetailFragment detailFragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(ATHLETE, athlete);

        detailFragment.setArguments(bundle);

        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_layout, container, false);

        TextView name = (TextView) view.findViewById(R.id.detail_one);
        TextView position = (TextView) view.findViewById(R.id.detail_two);
        TextView jerseyNumber = (TextView) view.findViewById(R.id.detail_three);

        Bundle bundle = getArguments();
        Athlete athlete = (Athlete) bundle.getSerializable(ATHLETE);

        if (athlete != null) {
            name.setText(athlete.getName());
            position.setText(athlete.getPosition());
            jerseyNumber.setText(Integer.toString(athlete.getJerseyNumber()));
        }

        return view;
    }
}
