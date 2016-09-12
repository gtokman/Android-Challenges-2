package com.garytokman.tokmangary_ce06.Fragments;

// Gary Tokman
// JAV2 - 1609
// BookListFragment

import android.app.AlertDialog;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.garytokman.tokmangary_ce06.Adapters.BookAdapter;
import com.garytokman.tokmangary_ce06.Helpers.CursorHelper;
import com.garytokman.tokmangary_ce06.Helpers.ReadBookProvider;

public class BookListFragment extends ListFragment {


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ReadBookProvider readBookProvider = new ReadBookProvider(getActivity().getContentResolver());
        Cursor bookCursor = readBookProvider.getBookData();

        BookAdapter bookAdapter = new BookAdapter(getActivity(), bookCursor, 1);
        setListAdapter(bookAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor selectedItem = (Cursor) l.getAdapter().getItem(position);
        CursorHelper cursorHelper = new CursorHelper(selectedItem);

        alert("Alert", cursorHelper.getBookDescription()).show();
    }

    private AlertDialog.Builder alert(String title, String message) {

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton("OK", null);

        return alert;
    }
}
