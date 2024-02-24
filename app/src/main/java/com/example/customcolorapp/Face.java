/**
 * @Author Theresa Wunderlich
 * @Date 2.24.2024
 **/

package com.example.customcolorapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class Face extends SurfaceView {

    // instance variables
    private FaceModel faceModel;
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        faceModel = new FaceModel();
        randomize();
        setBackgroundColor(Color.WHITE); //better than black default
    } // Face

    // initializes all the variables to randomly selected values
    // called by the constructor
    public void randomize() {
            faceModel.hairLength = (int) ( (Math.random() * 3) + 1) ;
            faceModel.skinRed = (int) (Math.random() * 256);
            faceModel.skinGreen = (int) (Math.random() * 256);
            faceModel.skinBlue = (int) (Math.random() * 256);
            faceModel.eyeRed = (int) (Math.random() * 256);
            faceModel.eyeGreen = (int) (Math.random() * 256);
            faceModel.eyeBlue = (int) (Math.random() * 256);
            faceModel.hairRed = (int) (Math.random() * 256);
            faceModel.hairGreen = (int) (Math.random() * 256);
            faceModel.hairBlue = (int) (Math.random() * 256);

            skinColor = Color.argb(255, faceModel.skinRed, faceModel.skinGreen, faceModel.skinBlue);
            eyeColor = Color.argb(255, faceModel.eyeRed, faceModel.eyeGreen, faceModel.eyeBlue);
            hairColor = Color.argb(255, faceModel.hairRed, faceModel.hairGreen, faceModel.hairBlue);
    } // randomize

    // draws this Face object upon a given Canvas object
    public void onDraw(Canvas canvas) {
        skinColor = getSkinColor();
        eyeColor = getEyeColor();
        hairColor = getHairColor();
        hairStyle = faceModel.hairLength;
        hairPaint.setColor(hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
        skinPaint.setColor(skinColor);
        skinPaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        drawHair(canvas);
        drawFace(canvas);
        drawEyes(canvas);
    } // onDraw

    // helper methods for onDraw
    private void drawEyes(Canvas canvas) {
        canvas.drawOval(303, 200, 363, 300, eyePaint);
        canvas.drawOval(577, 200, 637, 300, eyePaint);
    } // drawEyes
    private void drawHair(Canvas canvas) {
        canvas.drawOval(10, 10, 910, (float) 1100/ hairStyle, hairPaint);
    } // drawHair
    private void drawFace(Canvas canvas) {
        canvas.drawOval(50, 60, 870, 1050, skinPaint);
    } // drawFace

    // getter methods
    public FaceModel getFaceModel() {return faceModel;}
    public int getSkinColor() {return skinColor;}
    public int getEyeColor() {return eyeColor;}
    public int getHairColor() {return hairColor;}

    // setter methods
    public void setSkinColor (int skinColor) {this.skinColor = skinColor;}
    public void setHairColor (int hairColor) {this.hairColor = hairColor;}
    public  void setEyeColor (int eyeColor) {this.eyeColor = eyeColor;}

} // class Face





