/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Primitives;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

import androidx.annotation.DrawableRes;

import com.minerva.andnevermindengine.Core.Settings.Settings;

import java.io.IOException;

public class Sprite extends Point {

    private Bitmap currentImage;
    Matrix matrix = new Matrix();

    ColorMatrix colorMatrix = new ColorMatrix(new float[]{255, 0, 0, 0, 0,
                                                          0, 255, 0, 0, 0,
                                                          0, 0, 255, 0, 0,
                                                          0, 0, 0, 255, 0});

    int width = 0, height = 0;

    int anchorX = 0, anchorY = 0;

    public Sprite(float x, float y, Bitmap bmp) {
        super(x, y);
        currentImage = bmp;
        autoResize();
        type = Type.SPRITE;
        width = bmp.getWidth();
        height = bmp.getHeight();
    }

    public Sprite(int x, int y, Bitmap bmp) {
        super(x, y);
        currentImage = bmp;
        autoResize();
        type = Type.SPRITE;
        width = bmp.getWidth();
        height = bmp.getHeight();
    }

    public Sprite(String s) {
        super(0, 0);
        currentImage = BitmapFactory.decodeFile(s);
        autoResize();
        this.type = Type.SPRITE;
        width = currentImage.getWidth();
        height = currentImage.getHeight();

    }

    public Sprite(Resources res, @DrawableRes int id){
        super(0, 0);
        currentImage = BitmapFactory.decodeResource(res, id);
        autoResize();
        type = Type.SPRITE;
        width = currentImage.getWidth();
        height = currentImage.getHeight();
    }

    public Sprite(String s, AssetManager am){
        super(0, 0);
        try {
            currentImage = BitmapFactory.decodeStream(am.open(s));
        } catch (IOException e){
            currentImage = null;
        }
        type = Type.SPRITE;
        width = currentImage.getWidth();
        height = currentImage.getHeight();
        autoResize();
        Log.d("Sprite", "Sprite " + s + " loaded!");
    }

    private void autoResize(){
        if (Settings.AutoResizeEnabled){
            resize(Settings.ScaleFactorX, Settings.ScaleFactorY);
        }
    }

    public void resize(int newX, int newY){
        currentImage = Bitmap.createScaledBitmap(currentImage, newX, newY, true);
        refreshData();
    }

    public void resize(float scaleX, float scaleY){
        currentImage = Bitmap.createScaledBitmap(currentImage,(int)(width*scaleX), (int)(height*scaleY), true);
        refreshData();
    }

    public void refreshData(){
        if (currentImage != null){
            this.width = currentImage.getWidth();
            this.height = currentImage.getHeight();
            matrix.setTranslate(x - anchorX, y - anchorY);
        }
    }

    public Bitmap getCurrentImage() {
        return currentImage;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setCurrentImage(Bitmap currentImage) {
        this.currentImage = currentImage;
        refreshData();
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
        refreshData();
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        refreshData();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        refreshData();
    }

    @Override
    public void setXY(float x, float y) {
        super.setXY(x, y);
        refreshData();
    }

    @Override
    public boolean isChoosed(float f, float g) {
        return (x > this.x && x < (this.x + this.width) && y > this.y
                && y < (this.y + this.height));
    }

    @Override
    public void draw(Paint p, Canvas c) {
        p.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(colorMatrix)));
        c.drawBitmap(currentImage, matrix, p);
        p.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0})));
    }

    public void setColor(ColorMatrix color) {
        this.colorMatrix = color;
    }

    public void setAnchorX(int anchorX) {
        this.anchorX = anchorX;
        refreshData();
    }

    public void setAnchorY(int anchorY) {
        this.anchorY = anchorY;
        refreshData();
    }

    public void setCenteredAnchor(){
        anchorX = width/2;
        anchorY = height/2;
        refreshData();
    }
}
