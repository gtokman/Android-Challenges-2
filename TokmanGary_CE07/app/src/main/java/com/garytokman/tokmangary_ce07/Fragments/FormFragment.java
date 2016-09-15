package com.garytokman.tokmangary_ce07.Fragments;

// Gary Tokman
// JAV2 - 1609
// FormFragment

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.garytokman.tokmangary_ce07.Model.Athlete;
import com.garytokman.tokmangary_ce07.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormFragment extends Fragment {

    public interface AthleteFormListener {
        void getNewAthlete(Athlete athlete);
    }

    private static final String TAG = "FromFrag";
    private List<EditText> mEditTexts;
    private EditText mName;
    private EditText mPosition;
    private EditText mNumber;
    private AthleteFormListener mAthleteFormListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Check class implements interface
        if (context instanceof AthleteFormListener) {
            mAthleteFormListener = (AthleteFormListener) context;
        } else {
            throw new IllegalArgumentException("Class does not implement interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_layout, container, false);

        // Init fields
        mName = (EditText) view.findViewById(R.id.name_text);
        mPosition = (EditText) view.findViewById(R.id.position_text);
        mNumber = (EditText) view.findViewById(R.id.jersey_number_text);
        mEditTexts = new ArrayList<>(Arrays.asList(mName, mPosition, mNumber));
        for (EditText editText : mEditTexts) {
            editText.addTextChangedListener(mTextWatcher);
        }

        return view;
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void afterTextChanged(Editable editable) {
            if (isFieldValid(mEditTexts)) {
                // Create athlete
                Athlete athlete = new Athlete(mName.getText().toString(),
                        mPosition.getText().toString(),
                        Integer.parseInt(mNumber.getText().toString()));
                // Notify delegate
                mAthleteFormListener.getNewAthlete(athlete);

                Log.d(TAG, "onTextChanged: " + athlete.toString());
            }
        }
    };

    private boolean isFieldValid(List <EditText> editTexts) {
        for (EditText editText : editTexts) {
            if (TextUtils.isEmpty(editText.getText())) {
                editText.setError("Invalid Field");
                return false;
            }
        }
        return true;
    }
}

