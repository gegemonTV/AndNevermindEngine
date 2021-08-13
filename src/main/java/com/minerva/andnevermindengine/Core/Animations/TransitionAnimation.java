/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Animations;

import android.os.Debug;
import android.util.Log;

import com.minerva.andnevermindengine.Core.Object.Property;
import com.minerva.andnevermindengine.Core.Object.Object;
import com.minerva.andnevermindengine.Core.Primitives.Point;
import com.minerva.andnevermindengine.Core.Settings.Settings;

public class TransitionAnimation extends Animation {

    public static final String TAG = "TransitionAnimation";

    private Object object;

    private Point pointStart, pointEnd;

    private float velocityX=0, velocityY=0;
    private float deltaX, deltaY;

    private float acceleration = 1;

    private boolean endless = false;

    public TransitionAnimation(Object object, Point pointStart, Point pointEnd) {
        this.object = object;
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;

        this.velocityX = Settings.TargetUpdateInterval * 0.001f * (pointEnd.getX() - pointStart.getX());
        this.velocityY = Settings.TargetUpdateInterval * 0.001f * (pointEnd.getY() - pointStart.getY());

        this.deltaX = Math.abs(pointEnd.getX()-pointStart.getX());
        this.deltaY = Math.abs(pointEnd.getY()-pointStart.getY());
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public boolean isEndless() {
        return endless;
    }

    public void setEndless(boolean endless) {
        this.endless = endless;
    }

    @Override
    public void run() {
        object.setX(object.getX() + velocityX * acceleration);
        object.setY(object.getY() + velocityY * acceleration);

        deltaX = Math.abs(pointEnd.getX() - object.getX());
        deltaY = Math.abs(pointEnd.getY() - object.getY());

        Log.d(TAG, "update: deltaX: " + deltaX);
        Log.d(TAG, "update: deltaY: " + velocityY);

        if (deltaX <= 1.5f && deltaY <= 1.5f){
            object.setX(pointEnd.getX());
            object.setY(pointEnd.getY());
            velocityY = 0;
            velocityX = 0;
            if(!endless){
                this.setEnded(true);
                controller.triggerOnAnimationEnded();
            } else{
                object.setX(pointStart.getX());
                object.setY(pointStart.getY());
            }
        }
    }
}
