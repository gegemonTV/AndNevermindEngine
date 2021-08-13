/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Object;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.graphics.Paint;

import androidx.annotation.DrawableRes;

import com.minerva.andnevermindengine.Core.Animations.AnimationController;
import com.minerva.andnevermindengine.Core.Listeners.OnClickListener;
import com.minerva.andnevermindengine.Core.Primitives.Sprite;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;

public abstract class Object {

    ArrayList<OnClickListener> onClickListeners = new ArrayList<>();

    public ArrayList<Property> properties = new ArrayList<>();
    protected Sprite currentSprite;
    protected ArrayList<ScheduledExecutorService> executors = new ArrayList<>();

    private float x, y;

    public void update(){
    }

    public void draw(Canvas c, Paint p){
        currentSprite.draw(p, c);
    }

    public boolean isSelected(float f, float g){
        return currentSprite.isChoosed(f, g);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        currentSprite.setX(x);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        currentSprite.setY(y);
    }

    public void clearProperties(){
        properties.clear();
    }

    public void addProperty(Property p){
        properties.add(p);
    }

    public void setColorFilter(ColorMatrix colorMatrix){
        currentSprite.setColor(colorMatrix);
    }

    public void setCurrentSprite(Sprite currentSprite) {
        this.currentSprite = currentSprite;
    }

    public void setCurrentSprite(Resources res, @DrawableRes int id) {
        this.currentSprite.setCurrentImage(BitmapFactory.decodeResource(res, id));
    }

    public void addOnClickListener(OnClickListener listener){
        onClickListeners.add(listener);
    }

    public void triggerOnClick(){
        for (OnClickListener l : onClickListeners){
            l.onClick();
        }
    }

    public void deleteOnClickListener(OnClickListener l){
        onClickListeners.remove(l);
    }

    public void deleteOnClickListener(int i){
        onClickListeners.remove(i);
    }

    public void clearOnClickListeners(){
        onClickListeners.clear();
    }
}
