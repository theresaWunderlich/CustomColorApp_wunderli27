/**
 * @Author Theresa Wunderlich
 * @Date 2.24.2024
 **/

package com.example.customcolorapp;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class FaceController extends Activity implements Spinner.OnItemSelectedListener,
        View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {
    private Face face;
    private FaceModel faceModel;
    private MainActivity main;
    private TextView redLabel;
    private TextView greenLabel;
    private TextView blueLabel;
    public FaceController (Face face, MainActivity activity) {
        this.face = face;
        this.faceModel = face.getFaceModel();
        this.main = activity;
        redLabel = main.findViewById(R.id.redTextLabel);
        greenLabel = main.findViewById(R.id.greenTextLabel);
        blueLabel = main.findViewById(R.id.blueTextLabel);
    } // FaceController

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        faceModel.hairLength = position + 1;
        face.invalidate();
    } // onItemSelected

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // this is left intentionally blank
    } // onNothingSelected

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.radioGroup){
            RadioGroup facePart = main.findViewById(R.id.radioGroup);
            int checkedId = facePart.getCheckedRadioButtonId();
            onCheckedChanged(facePart, checkedId);
        }
        else {
            face.randomize();
            main.spinner.setSelection(faceModel.hairLength - 1);
            if (faceModel.eyes) {
                main.red.setProgress(faceModel.eyeRed);
                main.blue.setProgress(faceModel.eyeBlue);
                main.green.setProgress(faceModel.eyeGreen);
                redLabel.setText("Red: " + faceModel.eyeRed);
                greenLabel.setText("Green: " + faceModel.eyeGreen);
                blueLabel.setText("Blue: " + faceModel.eyeBlue);
            }
            else if (faceModel.hair) {
                main.red.setProgress(faceModel.hairRed);
                main.blue.setProgress(faceModel.hairBlue);
                main.green.setProgress(faceModel.hairGreen);
                redLabel.setText("Red: " + faceModel.hairRed);
                greenLabel.setText("Green: " + faceModel.hairGreen);
                blueLabel.setText("Blue: " + faceModel.hairBlue);
            }
            else if (faceModel.skin) {
                main.red.setProgress(faceModel.skinRed);
                main.blue.setProgress(faceModel.skinBlue);
                main.green.setProgress(faceModel.skinGreen);
                redLabel.setText("Red: " +faceModel.skinRed);
                greenLabel.setText("Green: " + faceModel.skinGreen);
                blueLabel.setText("Blue: " + faceModel.skinBlue);
            }
            face.invalidate();
        }
    } // onClick

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (faceModel.hair) {
            if (seekBar.getId() == R.id.redSwitch) {
                faceModel.hairRed = progress;
            }
            else if (seekBar.getId() == R.id.blueSwitch) {
                faceModel.hairBlue = progress;
            }
            else if (seekBar.getId() == R.id.greenSwitch) {
                faceModel.hairGreen = progress;
            }
            face.setHairColor(Color.argb(255, faceModel.hairRed, faceModel.hairGreen, faceModel.hairBlue));
            redLabel.setText("Red: " + faceModel.hairRed);
            greenLabel.setText("Green: " + faceModel.hairGreen);
            blueLabel.setText("Blue: " + faceModel.hairBlue);
        }
        else if (faceModel.eyes) {
            if (seekBar.getId() == R.id.redSwitch) {
                faceModel.eyeRed = progress;
            }
            else if (seekBar.getId() == R.id.blueSwitch) {
                faceModel.eyeBlue = progress;
            }
            else if (seekBar.getId() == R.id.greenSwitch) {
                faceModel.eyeGreen = progress;
            }
            face.setEyeColor(Color.argb(255, faceModel.eyeRed, faceModel.eyeGreen, faceModel.eyeBlue));
            redLabel.setText("Red: " + faceModel.eyeRed);
            greenLabel.setText("Green: " + faceModel.eyeGreen);
            blueLabel.setText("Blue: " + faceModel.eyeBlue);
        }
        else if (faceModel.skin) {
            if (seekBar.getId() == R.id.redSwitch) {
                faceModel.skinRed = progress;
            }
            else if (seekBar.getId() == R.id.blueSwitch) {
                faceModel.skinBlue = progress;
            }
            else if (seekBar.getId() == R.id.greenSwitch) {
                faceModel.skinGreen = progress;
            }
            face.setSkinColor(Color.argb(255, faceModel.skinRed, faceModel.skinGreen, faceModel.skinBlue));
            redLabel.setText("Red: " + faceModel.skinRed);
            greenLabel.setText("Green: " + faceModel.skinGreen);
            blueLabel.setText("Blue: " + faceModel.skinBlue);
        }
        face.invalidate();
    } // onProgressChanged

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // this is left intentionally blank
    } // onStartTrackingTouch

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // this is left intentionally blank
    } // onStopTrackingTouch

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //get checked button
        RadioButton checkedPart = group.findViewById(checkedId);

            if(checkedPart.getId() == R.id.eyesButton) {
                faceModel.eyes = true;
                faceModel.hair = false;
                faceModel.skin = false;
                main.red.setProgress(faceModel.eyeRed);
                main.blue.setProgress(faceModel.eyeBlue);
                main.green.setProgress(faceModel.eyeGreen);
                redLabel.setText("Red: " + faceModel.eyeRed);
                greenLabel.setText("Green: " + faceModel.eyeGreen);
                blueLabel.setText("Blue: " + faceModel.eyeBlue);
            }
            else if (checkedPart.getId() == R.id.skinButton) {
                faceModel.eyes = false;
                faceModel.hair = false;
                faceModel.skin = true;
                main.red.setProgress(faceModel.skinRed);
                main.blue.setProgress(faceModel.skinBlue);
                main.green.setProgress(faceModel.skinGreen);
                redLabel.setText("Red: " + faceModel.skinRed);
                greenLabel.setText("Green: " + faceModel.skinGreen);
                blueLabel.setText("Blue: " + faceModel.skinBlue);
            }
            else if (checkedPart.getId() == R.id.hairButton){
                faceModel.eyes = false;
                faceModel.hair = true;
                faceModel.skin = false;
                main.red.setProgress(faceModel.hairRed);
                main.blue.setProgress(faceModel.hairBlue);
                main.green.setProgress(faceModel.hairGreen);
                redLabel.setText("Red: " + faceModel.hairRed);
                greenLabel.setText("Green: " + faceModel.hairGreen);
                blueLabel.setText("Blue: " + faceModel.hairBlue);
            }
            face.invalidate();
        } // onCheckedChange
} // FaceController
