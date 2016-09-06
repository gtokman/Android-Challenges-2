package com.garytokman.tokmangary_ce03.Model;

// Gary Tokman
// JAV2 - 1609
// Repositories

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Repositories {

    private static Repositories sRepositories;
    private List<Repository> mRepositories;

    private Repositories(Context context) {
        mRepositories = new ArrayList<>();
    }

    public void setRepositories(List<Repository> repositories) {
        if (!mRepositories.contains(repositories)) {
            mRepositories = repositories;
        }
    }

    public List<Repository> getRepositories() {
        return mRepositories;
    }

    public static Repositories getInstance(Context context) {
        if (sRepositories == null) {
            sRepositories = new Repositories(context);
        }

        return sRepositories;
    }

    // TODO: Save to file
}
