
/*
 * Created by Akshay J Patil on 15/2/18 6:39 PM
 * Copyright (c) 2018. All Rights Reserved.
 *
 * Last Modified 15/2/18 6:39 PM
 */

package com.pace.cs639spring.hw2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class AnimalDisplayListViewAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<DataItem> mDataItem;
    private View.OnClickListener onClickListener;
    private int mSelectedPosition= -1;
    //Adapter Constructor
    AnimalDisplayListViewAdapter(Context mContext, ArrayList<DataItem> mDataItem, View.OnClickListener onClickListener) {
        Context mContext1 = mContext;
        this.mDataItem= mDataItem;
        this.onClickListener= onClickListener;
        this.mInflater= LayoutInflater.from(mContext);
    }
    //a view holder to point to the data in the DataItem
    private class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        Button mNextFact;
        Button mDeleteFact;
        ViewHolder(View item){
            mImageView= (ImageView) item.findViewById(R.id.animal_image);
            mTextView= (TextView) item.findViewById(R.id.animal_fact_placeholder);
            mNextFact= (Button) item.findViewById(R.id.next_fact_button);
            mDeleteFact= (Button) item.findViewById(R.id.delete_fact_button);
            mNextFact.setOnClickListener(onClickListener);
            mDeleteFact.setOnClickListener(onClickListener);
            mNextFact.setFocusable(false);
            mDeleteFact.setFocusable(false);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        // for reuse of views
        if (convertView== null){
            convertView = mInflater.inflate(R.layout.list_item, null);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else viewHolder= (ViewHolder) convertView.getTag();
        DataItem item= (DataItem) getItem(position);
        //Attaching the data to the viewHolder
        viewHolder.mTextView.setText(String.format("%s\n%s", item.getmName(), item.getmFacts()));
        viewHolder.mTextView.setVisibility(mSelectedPosition== position? View.VISIBLE: View.GONE);
        viewHolder.mImageView.setImageResource(item.getmImageId());
        viewHolder.mImageView.setColorFilter(item.getmColorFilter(), PorterDuff.Mode.SRC_IN);
        viewHolder.mNextFact.setTag(position);
        viewHolder.mNextFact.setVisibility(viewHolder.mTextView.getVisibility());
        viewHolder.mDeleteFact.setTag(position);
        viewHolder.mDeleteFact.setVisibility(viewHolder.mNextFact.getVisibility());
        return convertView;
    }
    //Function to to set the position of the clicked row on list view
    void setmSelectedPosition(int position){
        mSelectedPosition= position;
    }
    //Function to get the position of the clicked item
    int getSelectedPosition(){
        return mSelectedPosition;
    }
    @Override
    public int getCount() {
        return mDataItem.size();
    }
    @Override
    public Object getItem(int position) {
        return mDataItem.get(position);
    }
    @Override
    public long getItemId(int position) {
        return mDataItem.indexOf(getItem(position));
    }
}
