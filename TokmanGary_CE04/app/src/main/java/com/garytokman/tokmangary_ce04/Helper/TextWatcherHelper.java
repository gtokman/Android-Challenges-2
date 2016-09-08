package com.garytokman.tokmangary_ce04.Helper;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.garytokman.tokmangary_ce04.Fragments.PersonFormFragment;
import com.garytokman.tokmangary_ce04.R;

import java.text.ParseException;

// Gary Tokman
// JAV2 - 1609
// TextWatcherHelper

public class TextWatcherHelper implements TextWatcher {

    private static final String TAG = "TextWatcher";
    private EditText mEditText;

    public void setEditText(EditText editText) {
        mEditText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        String text = editable.toString().trim();

            // Get text value
            switch (mEditText.getId()) {
                case R.id.firstname_text:
                    Log.d(TAG, "First name" + text);
                    if (!isTextEmpty(text)) {
                        PersonFormFragment.person.setFirstName(text);
                    }
                    break;
                case R.id.lastname_text:
                    Log.d(TAG, "Last name " + text);
                    if (!isTextEmpty(text)) {
                        PersonFormFragment.person.setLastName(text);
                    }
                    break;
                case R.id.number_text:
                    Log.d(TAG, "Number" + text);
                    if (!isTextEmpty(text)) {
                        PersonFormFragment.person.setEmployeeNumber(Integer.valueOf(text));
                    }
                    break;
                case R.id.hire_text:
                    Log.d(TAG, "Hire date " + text);
                    try {
                        if (!isTextEmpty(text)) {
                            PersonFormFragment.person.setHireDate(DateHelper.stringToDate(text));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.status_text:
                    Log.d(TAG, "Status " + text);
                    if (!isTextEmpty(text)) {
                        PersonFormFragment.person.setEmployeeStatus(text);
                    }
                    break;
            }

    }

    private boolean isTextEmpty(String text) {
        return text.isEmpty();
    }


}
