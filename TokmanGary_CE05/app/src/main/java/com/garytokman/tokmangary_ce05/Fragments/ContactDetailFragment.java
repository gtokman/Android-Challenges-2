package com.garytokman.tokmangary_ce05.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_ce05.R;

import java.io.Serializable;

// Gary Tokman
// JAVA 2 1609
// ContactDetailFragment

public class ContactDetailFragment extends Fragment {


    private static final String CONTACT_INFO = "Contact_Info";
    private static final String TAG = "ContactDetailFragment";

    public ContactDetailFragment newInstance(String cursor) {

        ContactDetailFragment contactDetailFragment = new ContactDetailFragment();

        // Create args
        Bundle arguments = new Bundle();
        arguments.putSerializable(CONTACT_INFO, (Serializable) cursor);

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
        TextView firstName = (TextView) view.findViewById(R.id.first_name_text);
        TextView lastName = (TextView) view.findViewById(R.id.last_name_text);
        TextView phoneNumber = (TextView) view.findViewById(R.id.phone_text);
        TextView email = (TextView) view.findViewById(R.id.email_text);

        Bundle arguments = getArguments();
        String cursor = (String) arguments.getSerializable(CONTACT_INFO);

        // Set properties
        contactsImage.setImageResource(R.drawable.ic_mood_bad_black_24dp);
        firstName.setText("Gary");
        lastName.setText("Tokman");
        phoneNumber.setText("1-800-hotline");
        email.setText("h4xxor4lyf3@gmail.com");

        return view;
    }
}
