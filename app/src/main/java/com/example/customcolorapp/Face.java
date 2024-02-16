/**
 * @Author Theresa Wunderlich
 * @Date 2.15.2024
 **/

package com.example.customcolorapp;

import android.graphics.Canvas;
import kotlin.random.Random;

public class Face {

    // instance variables
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    // default constructor with no parameters
    public Face() {
        randomize();
    }

    // initializes all the variables to randomly selected values
    // called by the constructor
    private void randomize() {
        skinColor = Random.Default.nextInt();
        eyeColor = Random.Default.nextInt();
        hairColor = Random.Default.nextInt();
        hairStyle = Random.Default.nextInt();
    }

    // draws this Face object upon a given Canvas object
    public void onDraw(Canvas canvas) {
        // this method does not do anything for now
        drawFace();
        drawHair();
        drawEyes();
    }

    // helper methods for onDraw
    private void drawEyes() {
        // this method is empty for now
    }
    private void drawHair() {
        // this method is empty for now
    }
    private void drawFace() {
        // this method is empty for now
    }
}
