package com.garytokman.tokmangary_ce04.Fragments;

// Gary Tokman
// JAV2 - 1609
// PersonDetailFragment

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garytokman.tokmangary_ce04.Model.Person;
import com.garytokman.tokmangary_ce04.R;

public class PersonDetailFragment extends Fragment {

    private static final String PERSON_DATA = "Person_Data";

    public PersonDetailFragment newInstance(Person person) {

        PersonDetailFragment personDetailFragment = new PersonDetailFragment();

        // Set arguments
        Bundle arguments = new Bundle();
        arguments.putSerializable(PERSON_DATA, person);

        // Add to fragment
        personDetailFragment.setArguments(arguments);

        return personDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.details_layout, container, false);

        // Init widgets
        TextView personName = (TextView) view.findViewById(R.id.person_name);
        TextView personNumber = (TextView) view.findViewById(R.id.person_number);
        TextView personHireDate = (TextView) view.findViewById(R.id.person_hire_date);
        TextView personStatus = (TextView) view.findViewById(R.id.person_status);

        // Get arguments
        Bundle arguments = getArguments();
        Person person = (Person) arguments.getSerializable(PERSON_DATA);

        if (person != null) {
            personName.setText(person.getFullName());
            personNumber.setText(String.valueOf(person.getEmployeeNumber()));
            personHireDate.setText(person.getHireDate().toString());
            personStatus.setText(person.getEmployeeStatus());
        }

        return view;
    }
}
