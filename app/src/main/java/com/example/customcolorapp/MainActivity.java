/**
 * @Author Theresa Wunderlich
 * @Date 2.24.2024
 **/

package com.example.customcolorapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Face faceView;
    Spinner spinner;
    SeekBar red;
    SeekBar green;
    SeekBar blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         External Citation
         Date: 13 Feb 2024
         Problem: Did not know how to set up a surface view
         Resource: CS 371 lab code
         Solution: I used the surface view setup from the lab. Just the two lines (34 and 35) :)
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        faceView = findViewById(R.id.surfaceView);
        FaceController faceController = new FaceController(faceView, this);

        /**
         External Citation
         Date: 13 Feb 2024
         Problem: Could not populate spinner with multiple elements
         Resource: https://developer.android.com/develop/ui/views/components/spinner#java
         Solution: I used the example code from this post.
         (I swear I put this citation for part A but it disappeared)
         */
        spinner = findViewById(R.id.hairStyleSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.hairStyle_array,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(faceController);

        // button
        Button randomFace = findViewById(R.id.randomFace);
        randomFace.setOnClickListener(faceController);

        // radio group
        RadioGroup facePart = findViewById(R.id.radioGroup);
        facePart.setOnCheckedChangeListener(faceController);

        // seek bars
        red = findViewById(R.id.redSwitch);
        red.setOnSeekBarChangeListener(faceController);
        green = findViewById(R.id.greenSwitch);
        green.setOnSeekBarChangeListener(faceController);
        blue = findViewById(R.id.blueSwitch);
        blue.setOnSeekBarChangeListener(faceController);
    }

}



