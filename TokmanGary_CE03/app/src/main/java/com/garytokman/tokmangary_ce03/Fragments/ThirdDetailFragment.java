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
// ThirdDetailFragment

public class ThirdDetailFragment extends BaseDetailFragment {
    private static final String THIRD_DETAIL = "Third_Detail";

    public ThirdDetailFragment newInstance(Repository repository) {

        // Create instance of self
        ThirdDetailFragment thirdDetailFragment = new ThirdDetailFragment();

        // Create bundle
        Bundle arguments = new Bundle();
        arguments.putSerializable(THIRD_DETAIL, repository);

        thirdDetailFragment.setArguments(arguments);

        return thirdDetailFragment;
    }

    @Override
    public View initializeDetailView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.third_detail, container, false);

        // Init widgets
        ImageView avatarImage = (ImageView) view.findViewById(R.id.avatar_third_detail);
        TextView repoName = (TextView) view.findViewById(R.id.name_thirdDetail);
        TextView repoLang = (TextView) view.findViewById(R.id.language_third_detail);
        TextView repoStarCount = (TextView) view.findViewById(R.id.stars_third_detail);

        // Set data
        Bundle arguments = getArguments();
        Repository repository = (Repository) arguments.getSerializable(THIRD_DETAIL);

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
