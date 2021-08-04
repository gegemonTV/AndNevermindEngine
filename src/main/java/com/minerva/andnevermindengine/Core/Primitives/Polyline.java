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
 * Represents class of line with three or more vertices
 */
public class Polyline extends Basic{

    private Point[] points;

    private Line[] lines;

    public Polyline(Point[] points) {
        this.points = points;
        this.type = Type.POLYLINE;
        updateLines();
    }

    /**
     * Function that checks whether the point was placed on line
     * @param f X-coordinate of point
     * @param g Y-coordinate of point
     * @return
     */
    @Override
    public boolean isChoosed(float f, float g) {
        //TODO: сделать проверку
        return false;
    }

    /**
     * @return current list of vertices of {@link Point} class
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * Function that sets new vertices
     * @param points new vertices
     */
    public void setPoints(Point[] points) {
        this.points = points;
        updateLines();
    }

    /**
     * Function that updates vertices
     */
    public void updateLines(){
        lines = new Line[points.length-1];
        for (int i = 0; i < points.length-1; i++){
            lines[i] = new Line(points[i], points[i+1]);
        }
    }
    /**
     * Function that draws polyline
     * @param p paint that would be used to draw object
     * @param c canvas on which object would be drawn
     */
    @Override
    public void draw(Paint p, Canvas c) {
        for (Line l : lines){
            l.draw(p, c);
        }
    }
}
