package com.fullsail.android.jav2ce09starter.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fullsail.android.jav2ce09starter.R;
import com.fullsail.android.jav2ce09starter.object.Person;

/**
 * Created by gtokman1 on 9/19/16.
 */
public class PersonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView mPersonDetails;
    Context mContext;

    public PersonHolder(View itemView, Context context) {
        super(itemView);

        // Init
        mPersonDetails = (TextView) itemView.findViewById(R.id.person_text_view);
        itemView.setOnClickListener(this);
        mContext = context;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(mContext, mPersonDetails.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void bindView(Person person) {
        // Set text view
        mPersonDetails.setText(person.getFullName() + " " + person.getAge());
    }
}
