package com.garytokman.tokmangary_ce08.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.garytokman.tokmangary_ce08.R;

import java.util.List;

// Gary Tokman
// JAV2 - 1609
// FormFragment

public class FormFragment extends Fragment {

    private List<EditText> mEditTexts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.form_layout, container, false);

        // Init
        EditText detailOne = (EditText) view.findViewById(R.id.detail_one);
        EditText detailTwo = (EditText) view.findViewById(R.id.detail_two);
        EditText detailThree = (EditText) view.findViewById(R.id.detail_three);

        return view;
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
