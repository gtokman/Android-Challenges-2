package com.fullsail.android.jav2integrative03;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher, ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.button_submit);
        if(button != null) {
            button.setOnClickListener(this);
        }

        EditText editText = (EditText)findViewById(R.id.edit_string);
        if(editText != null) {
            editText.addTextChangedListener(this);
        }

        ListView listView = (ListView)findViewById(R.id.list_strings);
        if(listView != null) {
            listView.setOnItemClickListener(this);
            listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        }
    }

//    View.OnClickListener mClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            addStringFromEditToList();
//        }
//    };

//    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//            showTextInDialog(adapterView, position);
//        }
//    };

//    TextWatcher mWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//            updateLetterCounter(editable.toString());
//        }
//    };

    @SuppressWarnings("unchecked")
    private void addStringFromEditToList() {
        EditText editText = (EditText)findViewById(R.id.edit_string);
        if(editText != null) {
            String text = editText.getText().toString();
            editText.setText("");

            if(text.trim().length() == 0) {
                return;
            }

            ListView listView = (ListView)findViewById(R.id.list_strings);
            if(listView != null) {
                ArrayAdapter<String> adapter = (ArrayAdapter<String>)listView.getAdapter();
                adapter.add(text);
            }
        }
    }

    private void updateLetterCounter(String text) {
        TextView textView = (TextView)findViewById(R.id.text_letters_entered);
        if(textView != null) {
            textView.setText(String.valueOf(text.length()));
        }
    }

    private void showTextInDialog(AdapterView adapterView, int position) {
        Adapter adapter = adapterView.getAdapter();
        String text = (String)adapter.getItem(position);
        new AlertDialog.Builder(this)
                .setTitle("String Selected")
                .setMessage(text)
                .setPositiveButton("OK", null)
                .show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_submit) {
            addStringFromEditToList();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        updateLetterCounter(editable.toString());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        showTextInDialog(adapterView, i);
    }
}
