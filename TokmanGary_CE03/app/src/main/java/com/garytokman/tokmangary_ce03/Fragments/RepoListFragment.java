package com.garytokman.tokmangary_ce03.Fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.garytokman.tokmangary_ce03.Model.Repositories;
import com.garytokman.tokmangary_ce03.Model.Repository;

import java.util.List;

// Gary Tokman
// JAV2 - 1609
// RepoListFragment

public class RepoListFragment extends ListFragment {

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
        Toast.makeText(getActivity(), listView.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
