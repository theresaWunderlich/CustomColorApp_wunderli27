/**
 * @Author Theresa Wunderlich
 * @Date 2.15.2024
 **/

package com.example.customcolorapp;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SpinnerActivity extends Activity implements Spinner.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner hairSpinner = findViewById(R.id.hairStyleSpinner);
        hairSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
