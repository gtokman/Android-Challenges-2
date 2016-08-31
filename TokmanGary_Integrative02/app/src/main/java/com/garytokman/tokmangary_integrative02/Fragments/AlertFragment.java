package com.garytokman.tokmangary_integrative02.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.garytokman.tokmangary_integrative02.R;

// Gary Guerman Tokman
// JAVA 2 1609
// AlertFragment

public class AlertFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Create alert
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.alert_title)
                .setMessage(R.string.alert_message)
                .setPositiveButton("OK", null);

        return builder.create();
    }

}
