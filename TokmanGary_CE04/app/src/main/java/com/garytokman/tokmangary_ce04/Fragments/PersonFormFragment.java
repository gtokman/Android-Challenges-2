package com.garytokman.tokmangary_ce04.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.garytokman.tokmangary_ce04.Helper.TextWatcherHelper;
import com.garytokman.tokmangary_ce04.Model.People;
import com.garytokman.tokmangary_ce04.Model.Person;
import com.garytokman.tokmangary_ce04.R;

// Gary Tokman
// JAV2 - 1609
// PersonListFragment

public class PersonFormFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "FormFragment";
    public static final Person person = new Person();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.form_layout, container, false);

        // Init
        EditText firstName = (EditText) view.findViewById(R.id.firstname_text);
        EditText lastName = (EditText) view.findViewById(R.id.lastname_text);
        EditText employeeNumber = (EditText) view.findViewById(R.id.number_text);
        EditText hireDate = (EditText) view.findViewById(R.id.hire_text);
        EditText employeeStatus = (EditText) view.findViewById(R.id.status_text);
        Button addButton = (Button) view.findViewById(R.id.add_button);
        addButton.setOnClickListener(this);

        // Set text watcher
        setTextWatcher(firstName);
        setTextWatcher(lastName);
        setTextWatcher(employeeNumber);
        setTextWatcher(hireDate);
        setTextWatcher(employeeStatus);

        return view;
    }

    private void setTextWatcher(EditText editText) {
        TextWatcherHelper watcherHelper = new TextWatcherHelper();

        editText.addTextChangedListener(watcherHelper);
        watcherHelper.setEditText(editText);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_button) {
            Log.d(TAG, "onClick: ");
            Log.d(TAG, "onClick: " + person.getFirstName() + " " + person.getLastName() + " " + person.getEmployeeNumber()
            + " " + person.getHireDate() + " " + person.getEmployeeStatus());

            // TODO: Check for null fields
            People.getInstance(getActivity()).addPeople(person);
        }
    }
}
