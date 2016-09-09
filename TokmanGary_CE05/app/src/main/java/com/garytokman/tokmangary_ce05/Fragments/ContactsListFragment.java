package com.garytokman.tokmangary_ce05.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Gary Tokman
// JAVA 2 1609
// ContactsListFragment

public class ContactsListFragment extends ListFragment {

    public interface OnContactSelected {
        void getSelectedContact(String cursor);
    }

    private OnContactSelected mOnContactSelected;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnContactSelected) {
            mOnContactSelected = (OnContactSelected) context;
        } else {
            throw new IllegalArgumentException("Class does not implement interface!");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            people.add("Gary Tokman");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, people);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), l.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
//        Cursor cursor = (Cursor) l.getAdapter().getItem(position);
        String cursor = l.getAdapter().getItem(position).toString();
        mOnContactSelected.getSelectedContact(cursor);
    }
}
