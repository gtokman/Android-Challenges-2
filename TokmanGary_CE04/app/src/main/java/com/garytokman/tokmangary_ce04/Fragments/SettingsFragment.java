package com.garytokman.tokmangary_ce04.Fragments;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.garytokman.tokmangary_ce04.R;

// Gary Tokman
// JAV2 - 1609
// SettingsFragment

public class SettingsFragment extends PreferenceFragment {

    private static final String TAG = "SettingsFrag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load xml
        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Find pref by key
        Preference preference = findPreference("CLICK");

        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Log.d(TAG, "onPreferenceClick() returned: ");
                return false;
            }
        });
    }
}
