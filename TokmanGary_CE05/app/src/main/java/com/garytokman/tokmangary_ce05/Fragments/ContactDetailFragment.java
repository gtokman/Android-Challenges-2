package com.garytokman.tokmangary_ce05.Fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_ce05.Helpers.ContactsCursorHelper;
import com.garytokman.tokmangary_ce05.Helpers.ContactsHelper;
import com.garytokman.tokmangary_ce05.R;

// Gary Tokman
// JAVA 2 1609
// ContactDetailFragment

public class ContactDetailFragment extends Fragment {

    private static final String CONTACT_INFO = "Contact_Info";
    private static final String TAG = "ContactDetail";

    public ContactDetailFragment newInstance(Cursor cursor) {

        ContactDetailFragment contactDetailFragment = new ContactDetailFragment();

        // Create args
        Bundle arguments = new Bundle();
        ContactsCursorHelper cursorHelper = new ContactsCursorHelper(cursor);
        arguments.putSerializable(CONTACT_INFO, cursorHelper);

        // Set args
        contactDetailFragment.setArguments(arguments);

        return contactDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.details_layout, container, false);

        // Init
        ImageView contactsImage = (ImageView) view.findViewById(R.id.contact_image);
        TextView name = (TextView) view.findViewById(R.id.name_text_view);
        TextView phoneNumber = (TextView) view.findViewById(R.id.phone_text);
        TextView email = (TextView) view.findViewById(R.id.email_text);

        Bundle arguments = getArguments();
        ContactsCursorHelper cursorHelper = (ContactsCursorHelper) arguments.getSerializable(CONTACT_INFO);

        // Set properties
        if (cursorHelper != null) {
            // Set Name and number
            name.setText(cursorHelper.getName());
            phoneNumber.setText(cursorHelper.getNumber());

            // Set email if exists
            ContactsHelper contactsHelper = new ContactsHelper(getActivity().getContentResolver());
            Cursor emailData = contactsHelper.getEmailData(cursorHelper.getContactId());
            ContactsCursorHelper emailHelper = new ContactsCursorHelper(emailData);
            String emailText = emailHelper.getEmail();
            Log.d(TAG, "onCreateView: " + emailText);
            email.setText(emailText);

            // Set image
            String imageUri = cursorHelper.getImage();
            if (imageUri == null) {
                contactsImage.setImageResource(R.drawable.ic_mood_bad_black_24dp);
            } else {
                Uri imageURI = Uri.parse(imageUri);
                contactsImage.setImageURI(imageURI);
            }
        }

        return view;
    }
}
