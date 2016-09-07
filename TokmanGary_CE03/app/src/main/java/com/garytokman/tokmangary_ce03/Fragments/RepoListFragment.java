package com.garytokman.tokmangary_ce03.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.garytokman.tokmangary_ce03.Model.Repositories;
import com.garytokman.tokmangary_ce03.Model.Repository;

import java.util.List;

// Gary Tokman
// JAV2 - 1609
// RepoListFragment

public class RepoListFragment extends ListFragment {


    public interface LoadDetailView {
        void getDetailData(Repository repository);
    }

    public LoadDetailView mLoadDetailView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LoadDetailView) {
            mLoadDetailView = (LoadDetailView) context;
        } else {
            throw new IllegalArgumentException("Class does not implement interface!");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Get repositories
        Repositories repositories = Repositories.getInstance(getActivity());

        // Set adapter
        List<Repository> repositoryList = repositories.getRepositories();

        if (!repositoryList.isEmpty()) {
            ArrayAdapter<Repository> arrayAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, repositoryList);

            setListAdapter(arrayAdapter);
        }
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        super.onListItemClick(listView, v, position, id);

        // Get repo
        Repository repository = (Repository) listView.getAdapter().getItem(position);

        // Notify
        mLoadDetailView.getDetailData(repository);
    }
}
