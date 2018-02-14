<<<<<<< HEAD
package com.pace.cs639spring.hw2;

import android.app.Activity;
import android.content.Context;
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

    Context mContext;
    ArrayList<DataItem> mDataItem= new ArrayList<DataItem>();
    LayoutInflater mInflater;

    public AnimalDisplayListViewAdapter(Context mContext, ArrayList<DataItem> mDataItem) {
        this.mContext = mContext;
        this.mDataItem= mDataItem;
        mInflater= LayoutInflater.from(this.mContext);
    }

    private class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        Button mNextFact;
        Button mDeleteFact;

        public  ViewHolder(View item){
            mImageView= (ImageView) item.findViewById(R.id.animal_image);
            mTextView= (TextView) item.findViewById(R.id.animal_fact_placeholder);
            mNextFact= (Button) item.findViewById(R.id.next_fact_button);
            mDeleteFact= (Button) item.findViewById(R.id.delete_fact_button);

            mNextFact.setFocusable(false);
            mDeleteFact.setFocusable(false);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder= null;

        // for reuse of views
        if (convertView== null){
            convertView= mInflater.inflate(R.layout.list_item, parent, false);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else viewHolder= (ViewHolder) convertView.getTag();

        //fill data
        DataItem item= (DataItem) getItem(position);
        viewHolder.mTextView.setText(item.getmFact());
        viewHolder.mImageView.setImageResource(item.getmImageId());

        return convertView;
    }

    @Override
    public int getCount() {
        return mDataItem.size();
=======
package com.pace.cs639spring.hw2.cs639springhw2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by kachi on 2/7/18.
 */

public class AnimalDisplayListViewAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
>>>>>>> origin/master
    }

    @Override
    public Object getItem(int position) {
<<<<<<< HEAD
        return mDataItem.get(position);
=======
        return null;
>>>>>>> origin/master
    }

    @Override
    public long getItemId(int position) {
<<<<<<< HEAD
        return mDataItem.indexOf(getItem(position));
    }

=======
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
>>>>>>> origin/master
}
