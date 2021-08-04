/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Scene;

import androidx.lifecycle.LifecycleOwner;

import com.minerva.andnevermindengine.Core.Object.Object;

import java.util.ArrayList;

public class Scene {

    Layer[] layers;

    private int currentLayer;

    public static final int ORIENTATION_VERTICAL = 0;
    public static final int ORIENTATION_HORIZONTAL = 1;

    private int orientation;

    private int layerCount;

    public int topLayer;

    public int bottomLayer = 0;

    public int width, height;

    LifecycleOwner owner;

    public Scene(int layerCount, int width, int height, LifecycleOwner owner) {
        this.owner = owner;

        this.layerCount = layerCount;
        this.width = width;
        this.height = height;
        if (this.width>this.height){
            orientation = Scene.ORIENTATION_HORIZONTAL;
        } else {
            orientation = Scene.ORIENTATION_VERTICAL;
        }
        topLayer = layerCount-1;
        layers = new Layer[layerCount];

        for (int i = 0; i< layerCount; i++){
            layers[i] = new Layer(i);
        }
    }

    public void setWH(int w, int h){
        this.width = w;
        this.height = h;
    }

    public void setCurrentLayer(int currentLayer) {
        if (currentLayer <= topLayer){
            this.currentLayer = currentLayer;
        } else{
            this.currentLayer = topLayer;
        }
    }

    public void addItem(Object object){
        layers[currentLayer].add(object);
    }

    public int getCurrentLayerNum() {
        return currentLayer;
    }

    public Layer getCurrentLayers() {
        return layers[currentLayer];
    }

    public void clear(){
        layers[currentLayer].clear();
    }

    public int getLayerCount() {
        return layerCount;
    }

    public void delete(int i){
        this.layers[currentLayer].delete(i);
    }

    public Layer getLayerByNum(int num){
        if (num < this.layerCount){
            return layers[num];
        }
        return null;
    }

    public int getOrientation() {
        return orientation;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Object selectObject(float f, float g){
        Object obj = null;
        obj = layers[currentLayer].select(f,g);
        return obj;
    }

    public void update(){
        for (Layer l : layers){
            l.update();
        }

    }
}
