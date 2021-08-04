/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Scene;

import android.graphics.Paint;

import com.minerva.andnevermindengine.Core.Object.Object;
import com.minerva.andnevermindengine.Core.Primitives.Basic;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    public ArrayList<Object> objects = new ArrayList<>();

    int level;

    public Paint paint;

    private boolean processing=false;

    public Layer(int level) {
        processing = true;
        this.level = level;
        paint = new Paint();
        processing= false;
    }

    public void add(Object object){
        processing = true;
        objects.add(object);
        processing = false;
    }

    public int getSize(){
        return objects.size();
    }

    public Object get(int i){
        return objects.get(i);
    }

    public void delete(int i){
        processing = true;
        objects.remove(i);
        processing = false;
    }

    public void clear(){
        processing = true;
        objects.clear();
        processing = false;
    }

    public void update(){
        processing = true;
        for (Object object: objects){
            if (object!=null){
                object.update();
            }
        }
        processing = false;
    }

    public Object select(float f, float g){
        Object tmp = null;
        for (int i = 0; i < objects.size(); i++){
            if (objects.get(i) != null && objects.get(i).isSelected(f, g)){
                tmp = objects.get(i);
                break;
            }
        }
        return tmp;
    }

    public void resize(float newX, float newY){
        processing = true;
        for (int i = 0; i < getSize(); i++){
        }
        processing = false;
    }

    public boolean isProcessing(){
        return this.processing;
    }
}
