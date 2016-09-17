package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.garytokman.tokmangary_ce08.Fragments.FormFragment;
import com.garytokman.tokmangary_ce08.Model.Person;
import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// FormActivity

public class FormActivity extends BaseActivity implements FormFragment.OnPersonListener {

    private static final String TAG = "FormActivity";
    private static final String EXTRA_STRING_FIRST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME";
    private static final String EXTRA_STRING_LAST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME";
    private static final String EXTRA_INTEGER_AGE = "com.fullsail.android.jav2ce08.EXTRA_INT_AGE";
    public Person mPerson;

    @Override
    protected Fragment getFragment() {
        return new FormFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.form_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.save_button) {

            if (mPerson != null) {

                Toast.makeText(this, "Saved person", Toast.LENGTH_SHORT).show();

                // Create intent and add extas
                Intent data = new Intent();
                data.putExtra(EXTRA_STRING_FIRST_NAME, mPerson.getFirstName());
                data.putExtra(EXTRA_STRING_LAST_NAME, mPerson.getLastName());
                data.putExtra(EXTRA_INTEGER_AGE, mPerson.getAge());
                setResult(RESULT_OK, data);

                // Pop off stack
                finish();
            } else {
                Toast.makeText(this, "No empty fields", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getPerson(Person person) {
        if (person != null) {
            mPerson = person;
        }
    }
}
