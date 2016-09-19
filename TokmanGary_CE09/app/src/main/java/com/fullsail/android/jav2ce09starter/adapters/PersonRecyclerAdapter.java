package com.fullsail.android.jav2ce09starter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fullsail.android.jav2ce09starter.R;
import com.fullsail.android.jav2ce09starter.object.Person;
import com.fullsail.android.jav2ce09starter.viewholders.PersonHolder;

import java.util.List;

// Gary Tokman
// JAV2 - 1609
// PersonRecyclerAdapter

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonHolder>{

    private final List<Person> mPersons;
    private final Context mContext;

    public PersonRecyclerAdapter(List<Person> persons, Context context) {
        mPersons = persons;
        mContext = context;
    }

    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate view to give to the holder
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.person_recycler_item, parent, false);

        return new PersonHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        // Bind person at position
        Person person = mPersons.get(position);
        holder.bindView(person);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }
}

