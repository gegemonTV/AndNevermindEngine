/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import com.minerva.andnevermindengine.Core.Object.Object;
import com.minerva.andnevermindengine.Core.Scene.Layer;
import com.minerva.andnevermindengine.Core.Scene.Scene;
import com.minerva.andnevermindengine.Core.Settings.Settings;

import java.util.TimerTask;

public class DrawerTask extends TimerTask {

    SurfaceHolder holder;
    Paint mainPaint;
    Scene scene;
    Layer layer;
    Canvas canvas;
    int k;

    public DrawerTask(SurfaceHolder holder, Scene scene) {
        this.holder = holder;
        this.scene = scene;
        this.mainPaint = new Paint();
        mainPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    public void run() {
        Log.d("Draw", scene.getClass().getName());
        try {
            canvas = null;
            canvas = holder.lockCanvas();
            canvas.drawRGB(0, 0, 0);
            for (int l = 0; l < scene.getLayerCount(); l++){
                layer = scene.getLayerByNum(l);
                if (layer != null){
                    mainPaint = layer.paint;
                    for (Object obj : layer.objects){
                        obj.draw(canvas, mainPaint);
                    }
                }
            }
            //scene.update();
            Settings.newFrame();
        } catch (Exception ignored){

        } finally {
            if(canvas != null){
                holder.unlockCanvasAndPost(canvas);
            }
        }

    }

    public void setScene(Scene s){
        this.scene = s;
    }
}
