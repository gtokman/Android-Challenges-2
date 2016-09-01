package com.garytokman.tokmangary_ce02.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import com.garytokman.tokmangary_ce02.Model.Athlete;
import com.garytokman.tokmangary_ce02.Model.SaveAthlete;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gtokman1 on 9/1/16.
 */
public class AthleteFragment extends ForumFragment {

    protected List<Athlete> mAthletes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SaveAthlete saveAthlete = new SaveAthlete(getActivity());
        mAthletes = saveAthlete.loadAthletes();

        // Check if array list exists
        if (mAthletes == null) {
            mAthletes = new ArrayList<>();
        }

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
