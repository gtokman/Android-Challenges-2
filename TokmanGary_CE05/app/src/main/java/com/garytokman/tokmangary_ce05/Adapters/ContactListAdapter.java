package com.garytokman.tokmangary_ce05.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_ce05.R;

// Gary Tokman
// JAVA 2 1609
// ContactListAdapter

public class ContactListAdapter extends CursorAdapter {

    public ContactListAdapter(Context context, Cursor c) {
        super(context, c, 1);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);

        return inflater.inflate(R.layout.contact_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.bindContact(cursor);
    }

    private static class ViewHolder {
        ImageView contactImage;
        TextView contactName;
        TextView contactNumber;

        public ViewHolder(View view) {
            contactImage = (ImageView) view.findViewById(R.id.item_image);
            contactName = (TextView) view.findViewById(R.id.item_name);
            contactNumber = (TextView) view.findViewById(R.id.item_number);
        }

        public void bindContact(Cursor cursor) {
            // TODO init with contact info

            // Set name and number
            contactName.setText(cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME)));
            contactNumber.setText(cursor.getString(cursor.getColumnIndex(CommonDataKinds.Phone.NUMBER)));

            // Set image
            String uriString = cursor.getString(cursor.getColumnIndex(CommonDataKinds.Phone.PHOTO_URI));
            if (uriString == null) {
                contactImage.setImageResource(R.drawable.ic_mood_bad_black_24dp);
            } else {
                Uri imageURI = Uri.parse(uriString);
                contactImage.setImageURI(imageURI);
            }
        }
    }

}
