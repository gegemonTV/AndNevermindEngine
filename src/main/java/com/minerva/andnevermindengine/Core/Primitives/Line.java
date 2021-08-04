/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Primitives;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Represents simple line with two vertices
 */
public class Line extends Basic{
    /**
     * Represents x coordinate of 1st vertex
     */
    private float x1,
    /**
     * represents y coordinate of 1st vertex
     */
            y1,
    /**
     * represents x coordinate of 2nd vertex
     */
            x2,
    /**
     * represents y coordinate of 2nd vertex
     */
            y2;

    /**
     * Constructor of simple line class
     * @param x1 represents x coordinate of 1st vertex
     * @param y1 represents y coordinate of 1st vertex
     * @param x2 represents x coordinate of 2nd vertex
     * @param y2 represents y coordinate of 2nd vertex
     */
    public Line(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        type = Type.LINE;
    }

    /**
     * Constructor of simple line class
     * @param p1 represents first vertex
     * @param p2 represents second vertex
     */
    public Line(Point p1, Point p2) {
        this.x1 = p1.getX();
        this.y1 = p1.getY();
        this.x2 = p2.getX();
        this.y2 = p2.getY();
        type = Type.LINE;
    }

    /**
     * Function that checks whether the point was placed on line
     * @param f X-coordinate of point
     * @param g Y-coordinate of point
     * @return true if point is placed on current line
     */
    @Override
    public boolean isChoosed(float f, float g) {
        //TODO: доделать функцию проверки на линии...
        return false;
    }

    /**
     * Draws line on canvas with paint
     * @param p paint that would be used to draw object
     * @param c canvas on which object would be drawn
     */
    @Override
    public void draw(Paint p, Canvas c) {
        c.drawLine(x1, y1, x2, y2, p);
    }
}
