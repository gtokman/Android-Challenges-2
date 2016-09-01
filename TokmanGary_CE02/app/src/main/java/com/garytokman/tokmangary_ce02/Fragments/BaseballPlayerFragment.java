package com.garytokman.tokmangary_ce02.Fragments;

// Gary Guerman Tokman
// JAVA 2 1609
// BaseballPlayerFragment

import android.text.Editable;

public class BaseballPlayerFragment extends AthleteFragment {
    @Override
    public String getCustomHintText() {
        return "Number of Homeruns";
    }

    @Override
    public void afterTextChanged(Editable editable) {
        super.afterTextChanged(editable);

        // Load model

    }
}
