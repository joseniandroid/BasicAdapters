package com.training.android.basicadapters.models;

public class Movie {

    private String mTitle;
    private String mGenre;
    private String mSummary;
    private int mImageId;

    public Movie() {
    }

    public Movie(String title, String genre, String summary, int imageId) {
        mTitle = title;
        mGenre = genre;
        mSummary = summary;
        mImageId = imageId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Movie setTitle(String title) {
        mTitle = title;
        return this;
    }

    public String getGenre() {
        return mGenre;
    }

    public Movie setGenre(String genre) {
        mGenre = genre;
        return this;
    }

    public String getSummary() {
        return mSummary;
    }

    public Movie setSummary(String summary) {
        mSummary = summary;
        return this;
    }

    public int getImageId() {
        return mImageId;
    }

    public Movie setImageId(int imageId) {
        mImageId = imageId;
        return this;
    }
}
