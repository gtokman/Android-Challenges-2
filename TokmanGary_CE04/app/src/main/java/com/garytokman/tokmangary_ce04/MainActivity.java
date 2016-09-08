package com.garytokman.tokmangary_ce04;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce04.Fragments.PersonDetailFragment;
import com.garytokman.tokmangary_ce04.Fragments.PersonFormFragment;
import com.garytokman.tokmangary_ce04.Fragments.PersonListFragment;
import com.garytokman.tokmangary_ce04.Fragments.SettingsFragment;
import com.garytokman.tokmangary_ce04.Model.Person;

// Gary Tokman
// JAV2 - 1609
// MainActivity


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, PersonListFragment.OnSelectedRowClick {

    private static final String LIST_FRAGMENT = "List_Fragment";
    private static final String TAG = "MainActivity";
    private static final String PERSON_DETAIL = "Person_Detail";
    private static final String PERSON_FORM = "Person_Form";
    private static final String SETTINGS = "Settings";

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
        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);
        Button listButton = (Button) findViewById(R.id.list_button);
        listButton.setOnClickListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(LIST_FRAGMENT);

        if (fragment == null) {
            fragment = new PersonListFragment();
            replaceFragment(fragment, LIST_FRAGMENT);
        }
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager
                .beginTransaction()
                .replace(R.id.custom_container, fragment, tag)
                .commit();
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.settings_button) {
            Log.d(TAG, "onClick: Click!");
            // TODO: Show settings fragment
            SettingsFragment settingsFragment = new SettingsFragment();
            replaceFragment(settingsFragment, SETTINGS);
        } else if (viewId == R.id.register_button) {

            PersonFormFragment personFormFragment = new PersonFormFragment();
            replaceFragment(personFormFragment, PERSON_FORM);
        } else if (viewId == R.id.list_button) {
            PersonListFragment personListFragment = new PersonListFragment();
            replaceFragment(personListFragment, LIST_FRAGMENT);
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
        // Add detail fragments
        PersonDetailFragment personDetailFragment = new PersonDetailFragment().newInstance(person);
        replaceFragment(personDetailFragment, PERSON_DETAIL);
    }
}
