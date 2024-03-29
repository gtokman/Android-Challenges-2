package com.garytokman.tokmangary_ce02.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.garytokman.tokmangary_ce02.Model.Athlete;
import com.garytokman.tokmangary_ce02.Model.SaveAthlete;
import com.garytokman.tokmangary_ce02.R;

import java.util.ArrayList;
import java.util.List;

// Gary Guerman Tokman
// JAVA 2 1609
// ForumFragment

public abstract class ForumFragment extends Fragment implements TextWatcher, View.OnClickListener {

    public static final String TAG = "ForumFragment";
    protected EditText mNameEditText;
    protected EditText mPositionEditText;
    protected EditText mAgeEditText;
    protected EditText mCustomEditText;
    protected List<Athlete> mAthletes;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Init
        SaveAthlete saveAthlete = new SaveAthlete(getActivity());
        mAthletes = saveAthlete.loadAthletes();

        // Check if array list exists
        if (mAthletes == null) {
            mAthletes = new ArrayList<>();
        }

        // Inflate fragment layout
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.form_fragment, container, false);

        // Init Widgets
        Button saveButton = (Button) view.findViewById(R.id.save_button);
        mNameEditText = (EditText) view.findViewById(R.id.name_text);
        mPositionEditText = (EditText) view.findViewById(R.id.position_text);
        mAgeEditText = (EditText) view.findViewById(R.id.age_text);
        mCustomEditText = (EditText) view.findViewById(R.id.custom_text);
        mCustomEditText.setHint(getCustomHintText());

        // Listeners
        mNameEditText.addTextChangedListener(this);
        mPositionEditText.addTextChangedListener(this);
        mAgeEditText.addTextChangedListener(this);
        mCustomEditText.addTextChangedListener(this);
        saveButton.setOnClickListener(this);

        return view;
    }

    void clearTextFields() {
        // Clear fields
        mNameEditText.getText().clear();
        mPositionEditText.getText().clear();
        mAgeEditText.getText().clear();
        mCustomEditText.getText().clear();
    }

    protected String getText(EditText editText) {
        String enteredText = editText.getText().toString().trim();
        if (enteredText.isEmpty()) {
            Toast.makeText(getActivity(), "No empty text", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            return enteredText + "";
        }
    }

    protected abstract String getCustomHintText();
}
