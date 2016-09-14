package com.garytokman.tokmangary_ce06.Model;

// Gary Tokman
// JAV2 - 1609
// Article

public class Article {

    private final String mTitle;
    private final String mThumbnail;
    private final String mBody;

    public Article(String title, String thumbnail, String body) {
        mTitle = title;
        mThumbnail = thumbnail;
        mBody = body;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getBody() {
        return mBody;
    }
}
