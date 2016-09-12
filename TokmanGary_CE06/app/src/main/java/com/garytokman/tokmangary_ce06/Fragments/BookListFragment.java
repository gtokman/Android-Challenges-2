package com.garytokman.tokmangary_ce06.Fragments;

// Gary Tokman
// JAV2 - 1609
// BookListFragment

import android.app.AlertDialog;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookListFragment extends ListFragment {


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> people = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            people.add("Gary Tokman");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, people);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String name = l.getAdapter().getItem(position).toString();
        alert("Alert", name).show();
    }

    private AlertDialog.Builder alert(String title, String message) {

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton("OK", null);

        return alert;
    }
}
