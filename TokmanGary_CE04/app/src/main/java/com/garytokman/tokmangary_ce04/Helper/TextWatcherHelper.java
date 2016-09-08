package com.garytokman.tokmangary_ce04.Helper;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.garytokman.tokmangary_ce04.R;

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

        String text = editable.toString();

            // Get text value
            switch (mEditText.getId()) {
                case R.id.firstname_text:
                    Log.d(TAG, "First name" + text);
                    break;
                case R.id.lastname_text:
                    Log.d(TAG, "Last name " + text);
                    break;
                case R.id.number_text:
                    Log.d(TAG, "Number" + text);
                    break;
                case R.id.hire_text:
                    Log.d(TAG, "Hire date " + text);
                    break;
                case R.id.status_text:
                    Log.d(TAG, "Status " + text);
                    break;
            }
    }

    private boolean isTextEmpty(String text) {
        return text.isEmpty();
    }
}
