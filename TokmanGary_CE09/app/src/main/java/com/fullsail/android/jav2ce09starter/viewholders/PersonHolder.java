package com.fullsail.android.jav2ce09starter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fullsail.android.jav2ce09starter.R;
import com.fullsail.android.jav2ce09starter.object.Person;

// Gary Tokman
// JAV2 - 1609
// PersonHolder

public class PersonHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private static final String TAG = "PersonHolder";
    private final TextView mPersonDetails;

    public PersonHolder(View itemView) {
        super(itemView);

        // Init
        mPersonDetails = (TextView) itemView.findViewById(R.id.person_text_view);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);


    }

    @Override
    public void onClick(View view) {
//        Snackbar snackbar = Snackbar
//                .make(mView, mPersonDetails.getText().toString(), Snackbar.LENGTH_SHORT);
//
//        snackbar.show();

        Log.d(TAG, "onClick: ");
    }

    public void bindView(Person person) {
        // Set text view
        mPersonDetails.setText(person.getFullName() + " " + person.getAge());
    }

    @Override
    public boolean onLongClick(View view) {

        Log.d(TAG, "onLongClick: ");

        return true;
    }
}
