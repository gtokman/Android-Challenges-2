package com.garytokman.tokmangary_ce04.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.garytokman.tokmangary_ce04.Model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        List<Person> personList = new ArrayList<>();
        Date date = new Date();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person("Gary", "Tokman", 3, date , "FullTime"));
        }

        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(getActivity(), android.R.layout.simple_list_item_1, personList);
        setListAdapter(arrayAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get person
        Person person = (Person) l.getAdapter().getItem(position);

        // Notify person selected
        mOnSelectedRowClick.getSelectedPerson(person);
    }
}
