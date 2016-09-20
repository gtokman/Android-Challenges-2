package com.fullsail.android.jav2ce09starter.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fullsail.android.jav2ce09starter.R;
import com.fullsail.android.jav2ce09starter.object.Person;

import java.util.IllegalFormatException;

// Gary Tokman
// JAV2 - 1609
// PersonHolder

public class PersonHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public interface OnClickEvent {
        void itemDidPress(String description);
    }

    private static final String TAG = "PersonHolder";
    private final TextView mPersonDetails;
    private OnClickEvent mEvent;

    public PersonHolder(View itemView, Context context) {
        super(itemView);

        // Init
        mPersonDetails = (TextView) itemView.findViewById(R.id.person_text_view);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        try {
            mEvent = (OnClickEvent) context;
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        // Notify delegate
        mEvent.itemDidPress(mPersonDetails.getText().toString());
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
