package com.garytokman.tokmangary_ce02.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import com.garytokman.tokmangary_ce02.Model.Athlete;
import com.garytokman.tokmangary_ce02.Model.SaveAthlete;

import java.util.List;

// Gary Guerman Tokman
// JAVA 2 1609
// AthleteFragment

public class AthleteFragment extends ForumFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected String getCustomHintText() {
        return null;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    protected void saveAthleteList() {
        // Save list
        SaveAthlete saveAthlete = new SaveAthlete(getActivity(), mAthletes);
        saveAthlete.SaveAthletes();
    }

    @Override
    public void onClick(View view) {

    }
}
