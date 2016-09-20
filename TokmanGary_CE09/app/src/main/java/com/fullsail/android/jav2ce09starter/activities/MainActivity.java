package com.fullsail.android.jav2ce09starter.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fullsail.android.jav2ce09starter.R;
import com.fullsail.android.jav2ce09starter.fragment.PersonListFragment;
import com.fullsail.android.jav2ce09starter.fragment.PersonRecyclerListFragment;
import com.fullsail.android.jav2ce09starter.object.Person;
import com.fullsail.android.jav2ce09starter.util.PersonUtil;
import com.fullsail.android.jav2ce09starter.viewholders.PersonHolder;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements
        PersonListFragment.OnPersonInteractionListener, PersonHolder.OnClickEvent {

    private static final int REQUEST_FORM = 0x01001;
    private static final String TAG = "MainActivity";

    private int mCurrentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);

        // Set icon
        toolbar.setLogo(R.mipmap.ic_launcher);

        // Bottom bar
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottom_bar_main);
        bottomBar.setOnTabSelectListener(mReselectListener);

        // Fab
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.add_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FormActivity.class);
                startActivityForResult(intent, REQUEST_FORM);
            }
        });

        // Assigning the default filter.
        mCurrentFilter = PersonListFragment.FILTER_ALL;

        // Adding our list fragment one time only.
        if (savedInstanceState == null) {
//            PersonListFragment fragment = PersonListFragment.newInstance(mCurrentFilter);
            PersonRecyclerListFragment fragment = new PersonRecyclerListFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, PersonListFragment.TAG)
                    .commit();
        }
    }

    private final OnTabSelectListener mReselectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(@IdRes int tabId) {
            switch (tabId) {
                case R.id.tab_search_one:
                    mCurrentFilter = 0;
                    Log.d(TAG, "onTabReSelected: 0");
                    break;
                case R.id.tab_search_two:
                    mCurrentFilter = 1;
                    Log.d(TAG, "onTabReSelected: 1");
                    break;
                case R.id.tab_search_three:
                    mCurrentFilter = 2;
                    Log.d(TAG, "onTabReSelected: 2");
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only refresh the list if a save operation was successful.
        if (requestCode == REQUEST_FORM && resultCode == RESULT_OK) {
//            refreshList();
        }
    }

    @Override
    public void onPersonClicked(Person p) {
        Toast.makeText(this, p.getFullName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPersonLongClicked(final Person p) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.confirm_delete)
                .setMessage(R.string.confirm_delete_message)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PersonUtil.deletePerson(MainActivity.this, p);
//                        refreshList();
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }

    @Override
    public void itemDidPress(String description) {
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), description, Snackbar.LENGTH_SHORT);

        snackbar.show();
    }

    /**
     * Refreshes the current list fragment with the most recent filter.
     */
//    private void refreshList() {
//        PersonListFragment fragment = (PersonListFragment) getFragmentManager()
//                .findFragmentByTag(PersonListFragment.TAG);
//        if(fragment != null) {
//            fragment.refresh(mCurrentFilter);
//        }
//    }

}
