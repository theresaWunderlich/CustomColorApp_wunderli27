/**
 * @Author Theresa Wunderlich
 * @Date 2.15.2024
 **/

package com.example.customcolorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         External Citation
         Date: 13 Feb 2024
         Problem: Could not populate spinner with multiple elements
         Resource: https://developer.android.com/develop/ui/views/components/spinner#java
         Solution: I used the example code from this post.
         */
        Spinner spinner = (Spinner) findViewById(R.id.hairStyleSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.hairStyle_array,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
    }

}



