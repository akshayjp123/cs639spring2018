/*
 * Created by Akshay J Patil on 15/2/18 6:39 PM
 * Copyright (c) 2018. All Rights Reserved.
 *
 * Last Modified 15/2/18 6:34 PM
 */

package com.pace.cs639spring.hw2;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ArrayList<DataItem> mDataitems = new ArrayList<>();
    AnimalDisplayListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.animal_list_layout);
        View color1 = (View) findViewById(R.id.color_1);
        View color2 = (View) findViewById(R.id.color_2);
        View color3 = findViewById(R.id.color_3);
        View color4 = (View) findViewById(R.id.color_4);
        View color5 = (View) findViewById(R.id.color_5);
        Button addFact = (Button) findViewById(R.id.button);
        //Populating the data inside DataItem Object
        mDataitems.add(new DataItem(R.drawable.bird, "This is bird fact", "Bird"));
        mDataitems.add(new DataItem(R.drawable.cat, "This is cat fact", "Cat"));
        mDataitems.add(new DataItem(R.drawable.dog, "This is dog fact", "Dog"));
        mDataitems.add(new DataItem(R.drawable.ic_bee, "This is bee fact", "Bee"));
        mDataitems.add(new DataItem(R.drawable.ic_elephant, "This is elephant fact", "Elephant"));
        mDataitems.add(new DataItem(R.drawable.ic_goat, "This is goat fact", "Goat"));
        mDataitems.add(new DataItem(R.drawable.ic_horse, "This is horse fact", "Horse"));
        mDataitems.add(new DataItem(R.drawable.ic_lizard, "This is lizard fact", "Lizard"));
        mDataitems.add(new DataItem(R.drawable.ic_monkey, "This is monkey fact", "Monkey"));
        mDataitems.add(new DataItem(R.drawable.ic_mouse, "This is mouse Fact", "Mouse"));
        adapter = new AnimalDisplayListViewAdapter(getBaseContext(), mDataitems, new OnClickListener() {
            // ON CLICK LISTENERS FOR NEXT FACT AND DELETE FACT BUTTONS
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.next_fact_button:
                        //On click of Next Fact Button
                        int v = (int) view.getTag();
                        DataItem item = (DataItem) adapter.getItem(v);
                        item.getNextIndex();
                        break;
                    case R.id.delete_fact_button:
                        //On click of Delete Fact Button
                        int v1 = (int) view.getTag();
                        DataItem item1 = (DataItem) adapter.getItem(v1);
                        //Check if the item was the last item in the DataItem Array list
                        if (item1.deleteFact())
                            Toast.makeText(getBaseContext(), R.string.item_deleted, Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getBaseContext(), R.string.delete_fails, Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
            }
        });
        adapter.notifyDataSetChanged();
        mListView.setAdapter(adapter);
        mListView.setItemsCanFocus(false);
        //On item click listener for row click. to show the facts
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // return the position of the clicked item to the adapter
                adapter.setmSelectedPosition(i);
                adapter.notifyDataSetChanged();
            }
        });
        //Color Click Listener
        View.OnClickListener colorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get selected item from the adapter
                int mSelectedImage = adapter.getSelectedPosition();
                int viewBackgroundColor = ((ColorDrawable) view.getBackground()).getColor();
                DataItem i = (DataItem) adapter.getItem(mSelectedImage);
                //change the value of mcolorFilter in the DataItem
                i.setmColorFilter(viewBackgroundColor);
                adapter.notifyDataSetChanged();
            }
        };
        //Assigning color listener to the color views
        color1.setOnClickListener(colorListener);
        color2.setOnClickListener(colorListener);
        color3.setOnClickListener(colorListener);
        color4.setOnClickListener(colorListener);
        color5.setOnClickListener(colorListener);
        //Click Listener to add new fact to selected animal
        addFact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText factField = (EditText) findViewById(R.id.add_new_fact);
                int mPos = adapter.getSelectedPosition();
                String newFact = factField.getText().toString().trim();
                //Check if the field is empty
                if (TextUtils.isEmpty(newFact))
                    Toast.makeText(getBaseContext(), R.string.enter_fact, Toast.LENGTH_SHORT).show();
                    //Check if animal is selected
                else if (mPos == -1)
                    Toast.makeText(getBaseContext(), R.string.select_animal, Toast.LENGTH_SHORT).show();
                else {
                    // Add new fact to the DataItem ArrayList
                    DataItem addFactItem = (DataItem) adapter.getItem(mPos);
                    addFactItem.addNewFact(newFact);
                    factField.getText().clear();
                    factField.setEnabled(false);
                    Toast.makeText(getBaseContext(), R.string.fact_add_success, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
