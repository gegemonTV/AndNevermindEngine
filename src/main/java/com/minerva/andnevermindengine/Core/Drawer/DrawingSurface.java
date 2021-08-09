/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Drawer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.minerva.andnevermindengine.Core.Scene.Scene;
import com.minerva.andnevermindengine.Core.Settings.Settings;

import java.util.Timer;

public class DrawingSurface extends SurfaceView implements SurfaceHolder.Callback {

    Scene currentScene;

    DrawerTask drawerTask;

    Timer timer = new Timer();

    Canvas canvas;
    public DrawingSurface(Context context, Scene scene) {
        super(context);
        this.currentScene = scene;
        drawerTask = new DrawerTask(this.getHolder(), this.currentScene);
        this.getHolder().addCallback(this);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        timer.scheduleAtFixedRate(drawerTask, 0, Settings.TargetUpdateInterval);
        canvas = this.getHolder().lockCanvas();
        currentScene.setWH(canvas.getWidth(), canvas.getHeight());
        this.getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        currentScene.setWH(width, height);
        Settings.GenerateSettings(width, height);
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        timer.cancel();
    }

    public void setCurrentScene(Scene s){
        currentScene = s;
        drawerTask.setScene(currentScene);
        Log.d("SceneSetter", currentScene.getClass().getName());
    }

    public void triggerOnClickListeners(float f, float g){
        currentScene.triggerOnClickListeners(f, g);
    }
}
