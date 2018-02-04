package com.pace.cs639spring.hw1;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    RadioButton bird;
    RadioButton dog;
    RadioButton cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bird=findViewById(R.id.bird_img);
        dog= findViewById(R.id.dog_img);
        cat= findViewById(R.id.cat_img);


    }


    // Function to switch the information of the animal using fragments.
    public void FragmentSwitcher(View v){

        boolean checked = ((RadioButton) v).isChecked();

        Fragment fragment= new Fragment();

        FragmentManager fragmentManager= getFragmentManager();
        FragmentTransaction fragmentTransaction=  fragmentManager.beginTransaction();

        switch (v.getId()){
            //if bird is selected
            case R.id.bird_img:
                if (checked){
                    fragment= new bird_fragment();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }
                else {
                    fragment= new empty_fragment();

                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }
                break;
            //if dog is selected
            case R.id.dog_img:
                if (checked){
                    fragment= new dog_fragment();

                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }
                else {
                    fragment= new empty_fragment();

                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }
                break;
            //if cat is selected
            case R.id.cat_img:
                if (checked){
                    fragment= new cat_activity();

                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }
                else{
                    fragment= new empty_fragment();

                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }
        }
    }




    //Function to switch the colors of the animals

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void colorsetter(View v) {

        RadioGroup mAnimals= findViewById(R.id.colors);
        RadioGroup mColors= findViewById(R.id.colors_x);

        int status= mAnimals.getCheckedRadioButtonId();
        int colorStatus= mColors.getCheckedRadioButtonId();


        // if bird is selected
        if(status== R.id.bird_img){
            //if first color is selected
            if (colorStatus== R.id.color_1){
                ColorStateList colours = bird.getResources().getColorStateList(R.color.color1);
                bird.setBackgroundTintList(colours);
            }
            //if second color is selected
            if (colorStatus== R.id.color_2){
                ColorStateList colours = bird.getResources().getColorStateList(R.color.color2);
                bird.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_3){
                ColorStateList colours = bird.getResources().getColorStateList(R.color.color3);
                bird.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_4){
                ColorStateList colours = bird.getResources().getColorStateList(R.color.color4);
                bird.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_5){
                ColorStateList colours = bird.getResources().getColorStateList(R.color.color5);
                bird.setBackgroundTintList(colours);
            }

        }
        //if dog is selected
        if(status== R.id.dog_img){
            if (colorStatus== R.id.color_1){
                ColorStateList colours = dog.getResources().getColorStateList(R.color.color1);
                dog.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_2){
                ColorStateList colours = dog.getResources().getColorStateList(R.color.color2);
                dog.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_3){
                ColorStateList colours = dog.getResources().getColorStateList(R.color.color3);
                dog.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_4){
                ColorStateList colours = dog.getResources().getColorStateList(R.color.color4);
                dog.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_5){
                ColorStateList colours = dog.getResources().getColorStateList(R.color.color5);
                dog.setBackgroundTintList(colours);
            }
        }
        //if cat is selected
        if(status== R.id.cat_img){
            if (colorStatus== R.id.color_1){
                ColorStateList colours = cat.getResources().getColorStateList(R.color.color1);
                cat.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_2){
                ColorStateList colours = cat.getResources().getColorStateList(R.color.color2);
                cat.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_3){
                ColorStateList colours = cat.getResources().getColorStateList(R.color.color3);
                cat.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_4){
                ColorStateList colours = cat.getResources().getColorStateList(R.color.color4);
                cat.setBackgroundTintList(colours);
            }
            if (colorStatus== R.id.color_5) {
                ColorStateList colours = cat.getResources().getColorStateList(R.color.color5);
                cat.setBackgroundTintList(colours);
            }
        }
        else {
            //no item selected toasts message to select animal
            Toast toast=Toast.makeText(getApplicationContext(),"Please Select an animal first",Toast.LENGTH_SHORT);
            toast.show();
        }

    }


}
