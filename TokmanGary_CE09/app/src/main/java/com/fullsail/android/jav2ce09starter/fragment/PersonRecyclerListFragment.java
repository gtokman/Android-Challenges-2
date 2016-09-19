package com.fullsail.android.jav2ce09starter.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fullsail.android.jav2ce09starter.R;
import com.fullsail.android.jav2ce09starter.adapters.PersonRecyclerAdapter;
import com.fullsail.android.jav2ce09starter.object.Person;
import com.fullsail.android.jav2ce09starter.util.PersonUtil;

import java.util.List;

// Gary Tokman
// JAV2 - 1609
// PersonRecyclerListFragment

public class PersonRecyclerListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.person_recycler_view, container, false);

        // Init recycle view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.person_recycler_view);
        // Set manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Update
        updateList();

        return view;
    }

    private void updateList() {
        // Load people
        List<Person> persons = PersonUtil.loadPeople(getActivity());
        // Set adapter
        PersonRecyclerAdapter adapter = new PersonRecyclerAdapter(persons, getActivity());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }
}
