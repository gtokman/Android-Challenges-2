package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.garytokman.tokmangary_ce08.Model.Person;
import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// BaseActivity

public abstract class BaseActivity extends AppCompatActivity {

    private static final String FRAG_TAG = "Fragment_Tag";
    static final String EXTRA_STRING_FIRST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME";
    static final String EXTRA_STRING_LAST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME";
    static final String EXTRA_INTEGER_AGE = "com.fullsail.android.jav2ce08.EXTRA_INT_AGE";
    Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        // Set tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);


        // Add fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, getFragment(), FRAG_TAG)
                .commit();
    }

    protected abstract Fragment getFragment();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        Intent data = new Intent();

        switch (itemId) {
            case R.id.delete_button:
                // Delete
                passDataWithIntent(data);
                Toast.makeText(this, "Person deleted " + mPerson.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.save_button:

                if (mPerson != null) {

                    Toast.makeText(this, "Saved person " + mPerson.toString(), Toast.LENGTH_SHORT).show();
                    // Save
                    passDataWithIntent(data);
                } else {
                    Toast.makeText(this, "No empty fields", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void passDataWithIntent(Intent data) {
        // Delete
        data.putExtra(EXTRA_STRING_FIRST_NAME, mPerson.getFirstName());
        data.putExtra(EXTRA_STRING_LAST_NAME, mPerson.getLastName());
        data.putExtra(EXTRA_INTEGER_AGE, mPerson.getAge());
        setResult(RESULT_OK, data);

        finish();
    }
}
