package com.garytokman.tokmangary_ce08.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// DetailFragment

public class DetailFragment extends Fragment {

    private static final String EXTRA_STRING_FIRST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME";
    private static final String EXTRA_STRING_LAST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME";
    private static final String EXTRA_INTEGER_AGE = "com.fullsail.android.jav2ce08.EXTRA_INT_AGE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.details_layout, container, false);

        // Init
        TextView firstName = (TextView) view.findViewById(R.id.first_name_text);
        TextView lastName = (TextView) view.findViewById(R.id.last_name_text);
        TextView age = (TextView) view.findViewById(R.id.age_text);

        // Set values
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            firstName.setText(intent.getStringExtra(EXTRA_STRING_FIRST_NAME));
            lastName.setText(intent.getStringExtra(EXTRA_STRING_LAST_NAME));
            age.setText(String.valueOf(intent.getIntExtra(EXTRA_INTEGER_AGE, 1)));
        }

        return view;
    }
}
