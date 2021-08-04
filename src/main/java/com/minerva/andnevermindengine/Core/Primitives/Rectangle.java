/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Primitives;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Rectangle extends Basic {

    private Point p1, p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.type = Type.RECTANGLE;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    public boolean isChoosed(float f, float g) {
        return p1.getX() <= f && f <= p2.getX() && p1.getY() <= g && g <= p2.getY();
    }

    @Override
    public void draw(Paint p, Canvas c) {
        c.drawRect(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p);
    }
}
