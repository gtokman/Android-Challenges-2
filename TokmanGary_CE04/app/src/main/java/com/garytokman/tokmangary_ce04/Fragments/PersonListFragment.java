package com.garytokman.tokmangary_ce04.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.garytokman.tokmangary_ce04.Adapters.ListCursorAdapter;
import com.garytokman.tokmangary_ce04.Model.People;
import com.garytokman.tokmangary_ce04.Model.Person;

// Gary Tokman
// JAV2 - 1609
// PersonListFragment

public class PersonListFragment extends ListFragment {

    public interface OnSelectedRowClick {
        void getSelectedPerson(Person person);
    }

    private OnSelectedRowClick mOnSelectedRowClick;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnSelectedRowClick) {
            mOnSelectedRowClick = (OnSelectedRowClick) context;
        } else {
            throw new IllegalArgumentException("Class does not implement interface!");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Get people
        Cursor cursor = People.getInstance(getActivity()).queryAllPeople();

        // Create adapter
        ListCursorAdapter listCursorAdapter = new ListCursorAdapter(getActivity(), cursor);
        setListAdapter(listCursorAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get person
        Cursor personCursor = (Cursor) l.getAdapter().getItem(position);
        Person person = People.getInstance(getActivity()).getPerson(personCursor);

        // Notify person selected
        mOnSelectedRowClick.getSelectedPerson(person);
    }
}
