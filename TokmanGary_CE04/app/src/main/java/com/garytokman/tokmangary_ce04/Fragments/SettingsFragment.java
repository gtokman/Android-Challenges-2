package com.garytokman.tokmangary_ce04.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.garytokman.tokmangary_ce04.Model.People;
import com.garytokman.tokmangary_ce04.R;

// Gary Tokman
// JAV2 - 1609
// SettingsFragment

public class SettingsFragment extends PreferenceFragment {

    private static final String TAG = "SettingsFrag";
    private static final String PREFS_FILE = "com.garytokman.sharedpreferences.preferences";
    private static final String CURRENT_DATE_PATTERN = "date_pattern";


    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load xml
        addPreferencesFromResource(R.xml.settings);
        mSharedPreferences = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Delete button
        Preference deleteButton = findPreference("DELETE_BUTTON");

        deleteButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Log.d(TAG, "onPreferenceClick() returned: ");

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle(R.string.delete_title);
                alert.setMessage(R.string.delete_summary);
                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        People.getInstance(getActivity()).deletePerson(null, null);
                    }
                });
                alert.setNegativeButton("Cancel", null);
                alert.show();


                return false;
            }
        });

        // Get list value
        ListPreference listPreference = (ListPreference) findPreference("DATE_PREF");
        String currentValue = listPreference.getValue();

        // Save to shared
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(CURRENT_DATE_PATTERN, currentValue);
        Log.d(TAG, "onActivityCreated: value " + currentValue );
        editor.apply();
    }
}
