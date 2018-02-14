package com.pace.cs639spring.hw2;


public class DataItem {

    private int mImageId;
    private String mFact;

    public DataItem(int image, String fact) {
        this.mImageId= image;
        this.mFact= fact;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public String getmFact() {
        return mFact;
    }

    public void setmFact(String mFact) {
        this.mFact = mFact;
    }
}
