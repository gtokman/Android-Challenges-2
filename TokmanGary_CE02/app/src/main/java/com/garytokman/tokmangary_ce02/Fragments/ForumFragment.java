package com.garytokman.tokmangary_ce02.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.garytokman.tokmangary_ce02.R;

// Gary Guerman Tokman
// JAVA 2 1609
// ForumFragment

public abstract class ForumFragment extends Fragment {

    public static final String TAG = "ForumFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate fragment layout
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.form_fragment, container, false);

        // Init Widgets
        EditText nameEditText = (EditText) view.findViewById(R.id.name_text);
        EditText positionEditText = (EditText) view.findViewById(R.id.position_text);
        EditText ageEditText = (EditText) view.findViewById(R.id.age_text);
        EditText customEditText = (EditText) view.findViewById(R.id.custom_text);
        customEditText.setHint(getCustomHintText());

        // Logic

        return view;
    }

    public abstract String getCustomHintText();
}
