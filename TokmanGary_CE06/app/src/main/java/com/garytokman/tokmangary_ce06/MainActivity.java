package com.garytokman.tokmangary_ce06;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.garytokman.tokmangary_ce06.Fragments.BookListFragment;

// Gary Tokman
// JAV2 - 1609
// MainActivity

public class MainActivity extends AppCompatActivity {

    private static final String LIST_FRAG = "List_Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add list fragment
        FragmentManager fragmentManager = getFragmentManager();
        Fragment listFragment = fragmentManager.findFragmentByTag(LIST_FRAG);

        if (listFragment == null) {
            listFragment = new BookListFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.list_container, listFragment, LIST_FRAG)
                    .commit();
        }
    }
}
