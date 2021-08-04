/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Primitives;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends Basic {

    private float x, y, r;

    public Circle(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
        type = Type.CIRCLE;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    @Override
    public boolean isChoosed(float f, float g) {
        return false;
    }

    @Override
    public void draw(Paint p, Canvas c) {
        c.drawCircle(x, y, r, p);
    }
}
