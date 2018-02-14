package com.pace.cs639spring.hw2;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {


    public static int[] Images= new int[]{
            R.drawable.bird,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.ic_lizard,
            R.drawable.ic_mouse,
            R.drawable.ic_bee,
            R.drawable.ic_elephant,
            R.drawable.ic_horse,
            R.drawable.ic_goat,
            R.drawable.ic_monkey
    };


    public static String[][] Facts= new String[][]{
            {"This is bird fact", "bird second fact",null,null,null},
            {"This is dog fact", "dog second fact",null,null,null},
            {"This is Lizard fact", "Lizard second fact",null,null,null},
            {"This is mouse fact","mouse second fact",null,null,null},
            {"This is bee fact","bee second fact",null,null,null},
            {"This is elephant fact", "elephant second fact",null,null,null},
            {"This is horse fact", "horse second fact",null,null,null},
            {"This is goat fact", "goat second fact",null,null,null},
            {"This is monkey fact", "monkey second fact",null,null,null}
    };

    ListView mListView;
    ArrayList<DataItem> mDataitems;
    AnimalDisplayListViewAdapter adapter;

    public int mPosition;
    EditText mAddFactText;
    Button mNewFactButton;

    int positionofText=0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= findViewById(R.id.animal_list_layout);


        //Populating the data inside DataItem Object
        mDataitems= new ArrayList<DataItem>();
        for (int i=0; i < Facts.length; i++){
            DataItem newItem= new DataItem(Images[i], null);
            mDataitems.add(newItem);
        }
        adapter = new AnimalDisplayListViewAdapter(MainActivity.this, mDataitems);
        mListView.setAdapter(adapter);
        mListView.setItemsCanFocus(false);

        //Fact change on click
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                clearData();
                final DataItem item= (DataItem) adapter.getItem(position);
                item.setmFact(Facts[position][0]);

                // Button function to go to next fact of the selected item in list
                positionofText=0;
                Button nextfact= (Button) view.findViewById(R.id.next_fact_button);
                nextfact.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getBaseContext(), ""+ position, Toast.LENGTH_SHORT).show();
                        int current= Facts[mPosition].length;
                        String txt= Facts[mPosition][positionofText];
                        if(txt != null)
                        {
                            positionofText++;
                            item.setmFact(Facts[position][positionofText]);
                            adapter.notifyDataSetChanged();
                        }
                        else
                        {
                            Toast.makeText(getBaseContext(), R.string.add_fact_alert, Toast.LENGTH_SHORT).show();
                        }

                    }
                });


                //Button to delete the fact
                Button deleteFact= (Button) view.findViewById(R.id.delete_fact_button);
                deleteFact.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Facts[position][positionofText]= null;
                        Toast.makeText(getBaseContext(), R.string.delete_fact_alert, Toast.LENGTH_SHORT).show();
                    }
                });

                // Color Switching
                RadioGroup buttons= (RadioGroup) findViewById(R.id.radioGroup);
                int colorStatus= buttons.getCheckedRadioButtonId();
                View color1= findViewById(R.id.color_1);
                int imageId= item.getmImageId();
                ImageView mSelectedImage= view.findViewById(imageId);

                switch (colorStatus){
                    case R.id.color_1:
                        ColorStateList color= mSelectedImage.getResources().getColorStateList(R.color.color1);
                        mSelectedImage.setBackgroundTintList(color);
                        break;
                    case R.id.color_2:
                        ColorStateList color2= mSelectedImage.getResources().getColorStateList(R.color.color2);
                        mSelectedImage.setBackgroundTintList(color2);
                        break;
                    case R.id.color_3:
                        ColorStateList color3= mSelectedImage.getResources().getColorStateList(R.color.color3);
                        mSelectedImage.setBackgroundTintList(color3);
                        break;
                    case R.id.color_4:
                        ColorStateList color4= mSelectedImage.getResources().getColorStateList(R.color.color4);
                        mSelectedImage.setBackgroundTintList(color4);
                        break;
                    case R.id.color_5:
                        ColorStateList color5= mSelectedImage.getResources().getColorStateList(R.color.color5);
                        mSelectedImage.setBackgroundTintList(color5);
                        break;
                }

                adapter.notifyDataSetChanged();
                mPosition= position;
            }
        });


        // Adding new Text
        mNewFactButton= findViewById(R.id.button);
        mNewFactButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mAddFactText= findViewById(R.id.add_new_fact);

                if (Facts[mPosition][positionofText]!= null && positionofText< Facts[mPosition].length){
                    Facts[mPosition][positionofText]= mAddFactText.getText().toString();
                    Toast.makeText(getBaseContext(), R.string.new_fact_alert, Toast.LENGTH_SHORT).show();
                }
                else if(positionofText>= Facts[mPosition].length){
                    Toast.makeText(getBaseContext(), R.string.max_fact_alert, Toast.LENGTH_SHORT).show();
                }
                else {
                    positionofText++;
                }

            }
        });


    }
    // Function to clear the facts data
    public void clearData(){
        for (int j=0;j< Facts.length; j++){
            DataItem item= (DataItem) adapter.getItem(j);
            item.setmFact(null);
        }
    }



}
