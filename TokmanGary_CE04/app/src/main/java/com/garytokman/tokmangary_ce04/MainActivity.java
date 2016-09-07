package com.garytokman.tokmangary_ce04;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce04.Fragments.PersonDetailFragment;
import com.garytokman.tokmangary_ce04.Fragments.PersonListFragment;
import com.garytokman.tokmangary_ce04.Model.Person;

// Gary Tokman
// JAV2 - 1609
// MainActivity


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, PersonListFragment.OnSelectedRowClick {

    private static final String LIST_FRAGMENT = "List_Fragment";
    private static final String TAG = "MainActivity";
    private static final String PERSON_DETAIL = "Person_Detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        Spinner employeeDescSpinner = (Spinner) findViewById(R.id.employee_details_spinner);
        employeeDescSpinner.setOnItemSelectedListener(this);
        Spinner orderSpinner = (Spinner) findViewById(R.id.order_spinner);
        orderSpinner.setOnItemSelectedListener(this);
        ImageButton settingsButton = (ImageButton) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(LIST_FRAGMENT);

        if (fragment == null) {
            fragment = new PersonListFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.list_container, fragment, LIST_FRAGMENT)
                    .commit();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.settings_button) {
            Log.d(TAG, "onClick: Click!");
            // TODO: Show settings fragment
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // TODO: Call function to handle the selection
        if (adapterView.getId() == R.id.employee_details_spinner) {
            String selection = adapterView.getSelectedItem().toString();
            Log.d(TAG, "onItemSelected: First Spinner " + selection);
        } else if (adapterView.getId() == R.id.order_spinner) {
            String selection = adapterView.getSelectedItem().toString();
            Log.d(TAG, "onItemSelected: Second selection" + selection);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void getSelectedPerson(Person person) {
        Log.d(TAG, "getSelectedPerson() called with: " + "person = [" + person + "]");

        FragmentManager fragmentManager = getFragmentManager();
        PersonDetailFragment personDetailFragment = new PersonDetailFragment().newInstance(person);

        fragmentManager
                .beginTransaction()
                .replace(R.id.custom_container, personDetailFragment, PERSON_DETAIL)
                .addToBackStack(null)
                .commit();
    }
}
