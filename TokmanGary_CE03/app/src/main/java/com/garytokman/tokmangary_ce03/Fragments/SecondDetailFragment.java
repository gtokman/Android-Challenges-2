package com.garytokman.tokmangary_ce03.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_ce03.Model.Repository;
import com.garytokman.tokmangary_ce03.R;
import com.squareup.picasso.Picasso;

// Gary Tokman
// JAV2 - 1609
// SecondDetailFragment

public class SecondDetailFragment extends BaseDetailFragment {
    private static final String SECOND_DETAIL = "Second_Detail";

    public SecondDetailFragment newInstance(Repository repository) {

        // Create instance of self
        SecondDetailFragment secondDetailFragment = new SecondDetailFragment();

        // Create bundle
        Bundle arguments = new Bundle();
        arguments.putSerializable(SECOND_DETAIL, repository);

        secondDetailFragment.setArguments(arguments);

        return secondDetailFragment;
    }

    @Override
    public View initializeDetailView(LayoutInflater inflater, ViewGroup container) {

        // Inflate and init here!
        View view = inflater.inflate(R.layout.second_detail, container, false);

        // Init widgets
        ImageView avatarImage = (ImageView) view.findViewById(R.id.avatar_second_detail);
        TextView repoName = (TextView) view.findViewById(R.id.name_SecondDetail);
        TextView repoLang = (TextView) view.findViewById(R.id.language_second_detail);
        TextView repoStarCount = (TextView) view.findViewById(R.id.starts_second_detail);

        // Set data
        Bundle arguments = getArguments();
        Repository repository = (Repository) arguments.getSerializable(SECOND_DETAIL);

        if (repository != null) {
            // Set data
            Picasso.with(getActivity()).load(repository.getImageURl())
                    .placeholder(R.drawable.ic_portrait_black_24dp).into(avatarImage);
            repoName.setText(repository.getName());
            repoLang.setText(repository.getLanguage());
            repoStarCount.setText(String.valueOf(repository.getStartCount()));
        }

        return view;
    }

}
