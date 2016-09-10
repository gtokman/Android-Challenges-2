package com.garytokman.tokmangary_ce05;

import android.Manifest.permission;
import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.garytokman.tokmangary_ce05.Fragments.ContactDetailFragment;
import com.garytokman.tokmangary_ce05.Fragments.ContactsListFragment;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.os.Build.VERSION.SDK_INT;

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

        if (SDK_INT >= VERSION_CODES.M && !canReadContacts()) {
            // Read contacts
            requestPermissions(new String[]{permission.READ_CONTACTS}, 123);
        } else {
            // Request
            // Test
            addListFragment();
        }

    }

    private void addListFragment() {
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
    public void getSelectedContact(Cursor cursor) {
        // TODO: Load detail with selected contact
        ContactDetailFragment contactDetailFragment = new ContactDetailFragment().newInstance(cursor);
        addFragmentToStack(contactDetailFragment, CONTACTS_DETAIL, R.id.detail_container);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 123 && grantResults[0] == PERMISSION_GRANTED) {
            addListFragment();
        } else {
            Toast.makeText(this, "Grant app permission to read contacts!", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean canReadContacts() {
        return ContextCompat.checkSelfPermission(this, permission.READ_CONTACTS) == PERMISSION_GRANTED;
    }


}
