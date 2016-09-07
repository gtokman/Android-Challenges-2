package com.garytokman.tokmangary_ce03.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Gary Tokman
// JAV2 - 1609
// BaseDetailFragment

public abstract class BaseDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = initializeDetailView(inflater, container);

        return view;
    }

    public abstract View initializeDetailView(LayoutInflater inflater, ViewGroup container);
}
