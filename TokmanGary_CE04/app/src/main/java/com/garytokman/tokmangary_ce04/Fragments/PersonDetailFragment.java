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
import android.widget.Button;
import android.widget.TextView;

import com.garytokman.tokmangary_ce04.Database.PersonDatabaseSchema.PersonTable;
import com.garytokman.tokmangary_ce04.Model.People;
import com.garytokman.tokmangary_ce04.Model.Person;
import com.garytokman.tokmangary_ce04.R;

public class PersonDetailFragment extends Fragment {

    private static final String PERSON_DATA = "Person_Data";
    private static final String TAG = "PersonDetail";

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
        Button deleteButton = (Button) view.findViewById(R.id.delete_person_button);


        // Get arguments
        Bundle arguments = getArguments();
        final Person person = (Person) arguments.getSerializable(PERSON_DATA);

        if (person != null) {
            personName.setText(person.getFullName());
            personNumber.setText(String.valueOf(person.getEmployeeNumber()));
            personHireDate.setText(person.getHireDate().toString());
            personStatus.setText(person.getEmployeeStatus());
        }

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchValue = String.valueOf(person != null ? person.getEmployeeNumber() : 0);
                People.getInstance(getActivity()).deletePerson(null,
                        PersonTable.Columns.EMPLOYEE_ID + " = ?" , new String[] {searchValue});

                getFragmentManager().popBackStackImmediate();
            }
        });

        return view;
    }

}
