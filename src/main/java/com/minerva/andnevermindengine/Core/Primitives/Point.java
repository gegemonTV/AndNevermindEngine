/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Primitives;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author Linuxxx0id
 * @version 0.0.1
 * Class of the point primitive
 */
public class Point extends Basic {

    /**
     * Variable that representing current position of X-axis
     */
    protected float x;

    /**
     * Variable that representing current position of y-axis
     */
    protected float y;

    /**
     * Constructor of Point class
     * @param x X position of point
     * @param y Y position of point
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        type = Type.POINT;
    }

    /**
     * Constructor of Point class
     * @param x X position of point
     * @param y Y position of point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        type = Type.POINT;
    }

    /**
     *
     * @return returns current X position
     */
    public float getX() {
        return x;
    }

    /**
     * Sets new X position
     * @param x new X position
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return returns current Y position
     */
    public float getY() {
        return y;
    }

    /**
     * Sets new Y position
     * @param y new Y position
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Sets both new X and Y coordinates
     * @param x new X position
     * @param y new Y position
     */
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    /**
     * @param f X-coordinate of point
     * @param g Y-coordinate of point
     * @return true if x equals f and y equals g
     */
    @Override
    public boolean isChoosed(float f, float g) {
        return this.x == f && this.y == g;
    }

    /**
     * Draws dot on canvas
     * @param p paint that would be used to draw object
     * @param c canvas on which object would be drawn
     */
    @Override
    public void draw(Paint p, Canvas c) {
        c.drawPoint(this.x, this.y, p);
    }
}
