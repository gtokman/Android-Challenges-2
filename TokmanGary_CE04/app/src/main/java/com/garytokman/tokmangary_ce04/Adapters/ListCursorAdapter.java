package com.garytokman.tokmangary_ce04.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.garytokman.tokmangary_ce04.Model.People;
import com.garytokman.tokmangary_ce04.Model.Person;
import com.garytokman.tokmangary_ce04.R;

// Gary Tokman
// JAV2 - 1609
// ListCursorAdapter

public class ListCursorAdapter extends CursorAdapter {

    public ListCursorAdapter(Context context, Cursor c) {
        super(context, c, 1);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        // Inflate layout
        LayoutInflater inflater = LayoutInflater.from(context);

        return inflater.inflate(R.layout.cursor_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Bind person to views
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.bindPerson(People.getInstance(context).getPerson(cursor));
    }

    private static class ViewHolder {
        final TextView firstName;
        final TextView lastName;
        final TextView status;

        public ViewHolder(View view) {
            firstName = (TextView) view.findViewById(R.id.first_name_text);
            lastName = (TextView) view.findViewById(R.id.last_name_text);
            status = (TextView) view.findViewById(R.id.status_text_view);
        }


        public void bindPerson(Person person) {
            firstName.setText(person.getFirstName());
            lastName.setText(person.getLastName());
            status.setText(person.getEmployeeStatus());
        }
    }
}
