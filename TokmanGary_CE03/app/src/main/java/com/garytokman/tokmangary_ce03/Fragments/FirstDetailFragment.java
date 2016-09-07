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
// FirstDetailFragment

public class FirstDetailFragment extends BaseDetailFragment {

    private static final String REPO_DATA = "Repo_Data";

    public FirstDetailFragment newInstance(Repository repository) {

        // Create instance of self
        FirstDetailFragment firstDetailFragment = new FirstDetailFragment();

        // Create bundle
        Bundle arguments = new Bundle();
        arguments.putSerializable(REPO_DATA, repository);

        firstDetailFragment.setArguments(arguments);

        return firstDetailFragment;
    }

    @Override
    public View initializeDetailView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.first_detail, container, false);

        // Init widgets
        ImageView avatarImage = (ImageView) view.findViewById(R.id.repo_image);
        TextView repoName = (TextView) view.findViewById(R.id.repo_name);
        TextView repoLang = (TextView) view.findViewById(R.id.repo_lang);
        TextView repoStarCount = (TextView) view.findViewById(R.id.star_count);

        // Set data
        Bundle arguments = getArguments();
        Repository repository = (Repository) arguments.getSerializable(REPO_DATA);

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
