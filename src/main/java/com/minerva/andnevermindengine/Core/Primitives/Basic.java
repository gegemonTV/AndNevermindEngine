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
 * Primitives parent class
 */
public abstract class Basic {

    /**
     * <p>Enumerator of available types</p>
     * <li>
     * <ul>{@link Type#POINT} - simple point type</ul>
     * <ul>{@link Type#LINE} - simple line with two vertices</ul>
     * <ul>{@link Type#POLYLINE} - simple line with three or more vertices</ul>
     * <ul>{@link Type#RECTANGLE} - simple rectangle</ul>
     * <ul>{@link Type#CIRCLE} - simple circle</ul>
     * <ul>{@link Type#SPRITE} - sprite with bitmap image</ul>
     * </li>
     */
    public enum Type {
        POINT,
        LINE,
        POLYLINE,
        RECTANGLE,
        CIRCLE,
        SPRITE
    }

    /**
     * Represents type of current object
     */
    Type type;

   /* *//**
     * Function that updates parameters of the object
     *//*
    public abstract void update();
*/
    /**
     * Function that checks whether the object's space contains point (f; g)
     * @param f X-coordinate of point
     * @param g Y-coordinate of point
     * @return Returns true if object's space contains point (f; g)
     */
    public abstract boolean isChoosed(float f, float g);

    /**
     * Function that draws object on canvas with paint
     * @param p paint that would be used to draw object
     * @param c canvas on which object would be drawn
     */
    public abstract void draw(Paint p, Canvas c);
}
