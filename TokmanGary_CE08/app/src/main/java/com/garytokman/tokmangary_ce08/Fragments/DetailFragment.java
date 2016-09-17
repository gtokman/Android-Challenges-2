package com.garytokman.tokmangary_ce08.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garytokman.tokmangary_ce08.Model.Person;
import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// DetailFragment

public class DetailFragment extends Fragment {

    private static final String NEW_PERSON = "Person";

    public static DetailFragment newInstance(Person person) {
        DetailFragment detailFragment = new DetailFragment();

        // Create bundle
        Bundle bundle = new Bundle();
        bundle.putSerializable(NEW_PERSON, person);

        // Add bundle
        detailFragment.setArguments(bundle);

        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.details_layout, container, false);

        // Init
        TextView firstName = (TextView) view.findViewById(R.id.first_name_text);
        TextView lastName = (TextView) view.findViewById(R.id.last_name_text);
        TextView age = (TextView) view.findViewById(R.id.age_text);

        // Set values
        Bundle bundle = getArguments();
        Person person = (Person) bundle.getSerializable(NEW_PERSON);

        if (person != null) {
            firstName.setText(person.getFirstName());
            lastName.setText(person.getLastName());
            age.setText(String.valueOf(person.getAge()));
        }

        return view;
    }
}
