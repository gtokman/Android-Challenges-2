package com.garytokman.tokmangary_ce03.Model;

import java.io.Serializable;

// Gary Tokman
// JAV2 - 1609
// Repository

public class Repository implements Serializable {

    private String mName;
    private String mImageURl;
    private int mStartCount;
    private String mLanguage;

    public Repository(String name, String imageURl, int startCount, String language) {
        mName = name;
        mImageURl = imageURl;
        mStartCount = startCount;
        mLanguage = language;
    }

    public String getName() {
        return mName;
    }

    public String getImageURl() {
        return mImageURl;
    }

    public int getStartCount() {
        return mStartCount;
    }

    public String getLanguage() {
        return mLanguage;
    }

    @Override
    public String toString() {
        return mName;
    }
}
