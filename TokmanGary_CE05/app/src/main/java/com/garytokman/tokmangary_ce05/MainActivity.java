package com.garytokman.tokmangary_ce05;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.garytokman.tokmangary_ce05.Fragments.ContactDetailFragment;
import com.garytokman.tokmangary_ce05.Fragments.ContactsListFragment;

// Gary Tokman
// JAVA 2 1609
// MainActivity

public class MainActivity extends AppCompatActivity implements ContactsListFragment.OnContactSelected {

    private static final String LIST_FRAGMENT = "List_Fragment";
    private static final String CONTACTS_DETAIL = "Contacts_Detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add fragment
        ContactsListFragment contactsListFragment = new ContactsListFragment();
        addFragmentToStack(contactsListFragment, LIST_FRAGMENT, R.id.list_container);
    }

    private void addFragmentToStack(Fragment fragment, String tag, int layout) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(layout, fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void getSelectedContact(String cursor) {
        // TODO: Load detail with selected contact
        ContactDetailFragment contactDetailFragment = new ContactDetailFragment().newInstance(cursor);
        addFragmentToStack(contactDetailFragment, CONTACTS_DETAIL, R.id.detail_container);
    }
}
