package com.garytokman.tokmangary_ce04.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.garytokman.tokmangary_ce04.Helper.TextWatcherHelper;
import com.garytokman.tokmangary_ce04.R;

// Gary Tokman
// JAV2 - 1609
// PersonListFragment

public class PersonFormFragment extends Fragment {

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
}
