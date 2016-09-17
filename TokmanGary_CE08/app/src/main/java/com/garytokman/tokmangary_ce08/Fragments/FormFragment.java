package com.garytokman.tokmangary_ce08.Fragments;

import android.app.Fragment;
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

import com.garytokman.tokmangary_ce08.Model.Person;
import com.garytokman.tokmangary_ce08.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Gary Tokman
// JAV2 - 1609
// FormFragment

public class FormFragment extends Fragment {

    private static final String TAG = "Form Fragment";

    public interface OnPersonListener {
        void getPerson(Person person);
    }

    private List<EditText> mEditTexts;
    private OnPersonListener mOnPersonListener;
    private EditText mFirstNameDetail;
    private EditText mLastNameDetail;
    private EditText mAgeDetail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init interface
        try {
            mOnPersonListener = (OnPersonListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Must implement the interface!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.form_layout, container, false);

        // Init
        mFirstNameDetail = (EditText) view.findViewById(R.id.detail_one);
        mLastNameDetail = (EditText) view.findViewById(R.id.detail_two);
        mAgeDetail = (EditText) view.findViewById(R.id.detail_three);
        mEditTexts = new ArrayList<>(Arrays.asList(mFirstNameDetail, mLastNameDetail, mAgeDetail));

        // Add watcher
        for (EditText editText : mEditTexts) {
            editText.addTextChangedListener(mTextWatcher);
        }

        return view;
    }

    private final TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if (isFieldValid(mEditTexts)) {

                // Create person
                Person person = new Person(getStringValue(mFirstNameDetail),
                        getStringValue(mLastNameDetail),
                        Integer.parseInt(getStringValue(mAgeDetail)));


                Log.d(TAG, "afterTextChanged: " + person.toString());

                // Notify delegate
                mOnPersonListener.getPerson(person);
            }

        }
    };

    private String getStringValue(EditText editText) {
        return editText.getText().toString();
    }

    private boolean isFieldValid(List<EditText> editTexts) {
        for (EditText editText : editTexts) {
            if (TextUtils.isEmpty(editText.getText())) {
                editText.setError("Invalid Field");
                return false;
            }
        }
        return true;
    }
}
