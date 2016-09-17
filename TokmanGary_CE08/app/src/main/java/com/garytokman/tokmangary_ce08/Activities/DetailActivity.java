package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.garytokman.tokmangary_ce08.Fragments.DetailFragment;
import com.garytokman.tokmangary_ce08.Model.Person;
import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// DetailActivity

public class DetailActivity extends BaseActivity {

    private static final String EXTRA_STRING_FIRST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME";
    private static final String EXTRA_STRING_LAST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME";
    private static final String EXTRA_INTEGER_AGE = "com.fullsail.android.jav2ce08.EXTRA_INT_AGE";
    private Person mPerson;

    @Override
    protected Fragment getFragment() {
        // Get intent
        Intent intent = getIntent();
        // Init
        mPerson = new Person(intent.getStringExtra(EXTRA_STRING_FIRST_NAME),
                intent.getStringExtra(EXTRA_STRING_LAST_NAME),
                intent.getIntExtra(EXTRA_INTEGER_AGE, 1));


        return DetailFragment.newInstance(mPerson);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.delete_button) {

            // Delete
            Intent data = new Intent();
            data.putExtra(EXTRA_STRING_FIRST_NAME, mPerson.getFirstName());
            data.putExtra(EXTRA_STRING_LAST_NAME, mPerson.getLastName());
            data.putExtra(EXTRA_INTEGER_AGE, mPerson.getAge());
            setResult(RESULT_OK, data);

            finish();
            Toast.makeText(this, "Person deleted " + mPerson.toString(), Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
