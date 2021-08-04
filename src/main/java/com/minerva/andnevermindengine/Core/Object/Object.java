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

import com.minerva.andnevermindengine.Core.Primitives.Sprite;

import java.util.ArrayList;

public abstract class Object {

    public ArrayList<Property> properties = new ArrayList<>();
    protected Sprite currentSprite;

    private float x, y;

    public void update(){
        for (int i = 0; i < properties.size(); i++){
            properties.get(i).update();
            if (properties.get(i).isEnded()){
                properties.remove(i);
            }
        }
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
}
