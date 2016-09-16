package com.garytokman.tokmangary_ce08.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.garytokman.tokmangary_ce08.Fragments.FormFragment;
import com.garytokman.tokmangary_ce08.R;

// Gary Tokman
// JAV2 - 1609
// FormActivity

public class FormActivity extends BaseActivity {

    private static final String TAG = "FormActivity";
    private static final String EXTRA_STRING_FIRST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME";
    private static final String EXTRA_STRING_LAST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME";
    private static final String EXTRA_INTEGER_AGE = "com.fullsail.android.jav2ce08.EXTRA_INT_AGE";

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

            Toast.makeText(this, "Saved person", Toast.LENGTH_SHORT).show();


            Intent data = new Intent();
            data.putExtra(EXTRA_STRING_FIRST_NAME, "Gary");
            data.putExtra(EXTRA_STRING_LAST_NAME, "Tokman");
            data.putExtra(EXTRA_INTEGER_AGE, 1);
            setResult(RESULT_OK, data);



            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
