/*
 * Created by Akshay J Patil on 15/2/18 6:39 PM
 * Copyright (c) 2018. All Rights Reserved.
 *
 * Last Modified 15/2/18 6:02 PM
 */

package com.pace.cs639spring.hw2;


import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class DataItem {

    // content of the animals item
    private int mImageId;
    private String mName;
    private List<String> mFacts;
    private int mColorFilter;
    private int IndexofFact;

    // animal item constructor
    public DataItem(int mImageId, String initialFact, String mName) {
        this.mName= mName;

        this.mImageId = mImageId;
        this.mFacts = new ArrayList<String>();
        mFacts.add(initialFact);
        this.mColorFilter= Color.BLACK;
        this.IndexofFact= 0;
    }
    //animal name getter
    public String getmName() {
        return mName;
    }
    //animal name setter
    public void setmName(String mName) {
        this.mName = mName;
    }
    //animal color filter setter
    public void setmColorFilter(int mColorFilter) {
        this.mColorFilter = mColorFilter;
    }
    //animal color filter getter
    public int getmColorFilter() {
        return mColorFilter;
    }
    //animal new fact adder
    public void addNewFact(String newFact){
        mFacts.add(newFact);
    }
    //animal image getter
    public int getmImageId() {
        return mImageId;
    }
    //animal image setter
    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }
    //animal fact getter
    public String getmFacts() {
        return mFacts.get(IndexofFact).trim();
    }
    //animal fact  setter
    public void setmFacts(List<String> mFacts) {
        this.mFacts = mFacts;
    }
    //animal fact index incrementer
    public void getNextIndex(){
        if (IndexofFact >= mFacts.size()-1) IndexofFact = 0;
        else IndexofFact++;
    }
    //animal fact deleter
    public boolean deleteFact(){
        if (mFacts.size() <=1){
            return false;
        }
        else {
            mFacts.remove(IndexofFact);
            IndexofFact=0;
            return true;
        }
    }


}
