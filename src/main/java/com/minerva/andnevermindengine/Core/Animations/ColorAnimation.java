/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Animations;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.minerva.andnevermindengine.Core.Object.Property;
import com.minerva.andnevermindengine.Core.Object.Object;
import com.minerva.andnevermindengine.Core.Settings.Settings;

public class ColorAnimation extends Property {

    private Object object;
    ColorMatrix currentColorMatrix;

    private float velocityA, velocityR, velocityG, velocityB;

    private float[] colorMatrix = new float[] {1, 0,0,0,0,
                                               0,1,0,0,0,
                                               0,0,1,0,0,
                                               0,0,0,1,0};

    private float endA, endR, endG, endB, startA, startB, startR, startG;

    private float acceleration = 1;

    private boolean endless = false;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ColorAnimation(Object object, Color startColor, Color endColor) {
        this.object = object;

        colorMatrix[0] = startColor.red();
        colorMatrix[6] = startColor.green();
        colorMatrix[12] = startColor.blue();
        colorMatrix[18] = startColor.alpha();

        startA = startColor.alpha();
        startR= startColor.red();
        startG = startColor.green();
        startB = startColor.blue();

        endA = endColor.alpha();
        endR = endColor.red();
        endG = endColor.green();
        endB = endColor.blue();

        Log.d(getClass().getName(), startA + " " + startR);

        velocityA = (endColor.alpha() - startColor.alpha()) * 0.001f * Settings.TargetUpdateInterval * acceleration;
        velocityR = (endColor.red() - startColor.red()) * 0.001f * Settings.TargetUpdateInterval * acceleration;
        velocityG = (endColor.green() - startColor.green()) * 0.001f * Settings.TargetUpdateInterval * acceleration;
        velocityB = (endColor.blue() - startColor.blue()) * 0.001f * Settings.TargetUpdateInterval * acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void update() {
        if (Math.abs(colorMatrix[0] - endA) <= 0.05f && Math.abs(colorMatrix[18] - endB) <= 0.05f && Math.abs(colorMatrix[6] - endR) <= 0.05f && Math.abs(colorMatrix[12] - endG) <= 0.05f){
            colorMatrix[0] = endR;
            colorMatrix[6] = endG;
            colorMatrix[12] = endB;
            colorMatrix[18] = endA;
            if (!endless){
                setEnded(true);
            }
        }
        colorMatrix[0] += velocityR;
        colorMatrix[6] += velocityG;
        colorMatrix[12] += velocityB;
        colorMatrix[18] += velocityA;

        object.setColorFilter(new ColorMatrix(colorMatrix));


    }
}
