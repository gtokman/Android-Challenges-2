package com.garytokman.tokmangary_integrative02;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.garytokman.tokmangary_integrative02.Fragments.AlertFragment;

// Gary Guerman Tokman
// JAVA 2 1609
// MainActivity

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final AlertFragment ALERT_FRAGMENT = new AlertFragment();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Init
        Button dialogButton = (Button) findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do something
                Log.d(TAG, "onClick: Clicked");

                FragmentManager fragmentManager = getFragmentManager();
                ALERT_FRAGMENT.show(fragmentManager, TAG);
            }
        });
    }
}
