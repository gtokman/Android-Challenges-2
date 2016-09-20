package com.fullsail.android.jav2ce09starter.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IntDef;
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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

// Gary Tokman
// JAV2 - 1609
// PersonRecyclerListFragment

public class PersonRecyclerListFragment extends Fragment {



    // Don't be scared by the many annotations. This is here to ensure that you only
    // ever use a proper filter value with the newInstance or refresh methods.
    // Think of this like an enum, but without the enum keyword.
    @Retention(RetentionPolicy.CLASS)
    @IntDef({FILTER_ALL, FILTER_UNDER_30, FILTER_30_UP})
    public @interface FilterMode {}
    public static final int FILTER_ALL = 0;
    private static final int FILTER_UNDER_30 = 1;
    private static final int FILTER_30_UP = 2;
    private RecyclerView mRecyclerView;

    public static final String TAG = "PersonListFragment.TAG";

    private static final String ARG_FILTER = "PersonListFragment.ARG_FILTER";

    /**
     * Factory method for creating a PersonListFragment with appropriate bundle arguments.
     *
     * @param filter Defines the data to be shown based on one of the FilterMode values.
     * @return A new PersonListFragment with the proper arguments set.
     */
    public static PersonRecyclerListFragment newInstance(@FilterMode int filter) {
        PersonRecyclerListFragment fragment = new PersonRecyclerListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_FILTER, filter);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.person_recycler_view, container, false);

        // Init recycle view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.person_recycler_view);
        // Set manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Getting the filter that was passed into the fragment via newInstance.
        Bundle args = getArguments();
        @FilterMode int filter = args.getInt(ARG_FILTER, FILTER_ALL);

        // Update the list with the currently loaded data.
        refresh(filter);

        return view;
    }

    /**
     * Helper method for loading data, filtering it, and showing it in the list.
     *
     * @param filter FilterMode value that defines what data should show in the list.
     */
    public void refresh(@FilterMode int filter) {

        ArrayList<Person> people = PersonUtil.loadPeople(getActivity());
        people = filterPeople(people, filter);

        // Set adapter
        PersonRecyclerAdapter adapter = new PersonRecyclerAdapter(people, getActivity());
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * Helper method for taking a list of all saved data and filtering it to match
     * the passed in FilterMode value.
     *
     * @param people The list of people to be filtered.
     * @param filter How the list should be filtered.
     * @return The filtered list of people.
     */
    private ArrayList<Person> filterPeople(ArrayList<Person> people, @FilterMode int filter) {
        if(filter == FILTER_ALL) {
            return people;
        }

        ArrayList<Person> filtered = new ArrayList<>();
        for(Person p : people) {
            if(filter == FILTER_UNDER_30 && p.getAge() < 30) {
                filtered.add(p);
            } else if(filter == FILTER_30_UP && p.getAge() >= 30) {
                filtered.add(p);
            }
        }
        return filtered;
    }
}
