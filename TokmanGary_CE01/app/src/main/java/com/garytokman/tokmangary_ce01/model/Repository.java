package com.garytokman.tokmangary_ce01.model;

// Gary Guerman Tokman
// JAV2 - 1609
// Repository

public class Repository {

    private String mRepoName;
    private String mDescription;
    private int mStarCount;

    public Repository(int starCount, String description, String repoName) {
        mStarCount = starCount;
        mDescription = description;
        mRepoName = repoName;
    }

    public String getRepoName() {
        return mRepoName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getStarCount() {
        return mStarCount;
    }

    @Override
    public String toString() {
        return String.format("Repository: %s%nStars: %d%nDescription: %s", mRepoName, mStarCount, mDescription);
    }
}
