package com.garytokman.tokmangary_ce07.Fragments;

// Gary Tokman
// JAV2 - 1609
// FormFragment

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.garytokman.tokmangary_ce07.R;

public class FormFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_layout, container, false);

        // Init fields
        EditText name = (EditText) view.findViewById(R.id.name_text);
        EditText positon = (EditText) view.findViewById(R.id.position_text);
        EditText number = (EditText) view.findViewById(R.id.jersey_number_text);

        return view;
    }
}
