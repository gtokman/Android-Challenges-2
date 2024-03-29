package com.garytokman.tokmangary_ce01.model;

// Gary Guerman Tokman
// JAV2 - 1609
// Repository

import java.io.Serializable;

public class Repository implements Serializable {

    private String mRepoName;
    private String mDescription;
    private int mStarCount;

    public Repository(int starCount, String description, String repoName) {
        mStarCount = starCount;
        mDescription = description;
        mRepoName = repoName;
    }

    @Override
    public String toString() {
        return String.format("Repository: %s%nStars: %d%nDescription: %s", mRepoName, mStarCount, mDescription);
    }
}
